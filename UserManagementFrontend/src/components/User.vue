<template>
  <div class="hello">
      <div style="border: 1px solid gray; padding: 10px;">
        <h1><i class="fa fa-user-circle" aria-hidden="true"></i> {{ msg }}</h1>
        <button type="button" class="btn btn-success" v-on:click="isHidden = !isHidden"><i class="fa fa-bars" aria-hidden="true"></i> Show All User</button>
        <button type="button" class="btn btn-primary" style="margin-left: 30px" data-toggle="modal" data-target="#addUserModel"> <i class="fa fa-plus" aria-hidden="true"></i>   Add a User </button>
      </div>
    
    <table class="table table-striped" v-if="!isHidden" >
    <thead>
        <tr>
        <th scope="col">Index</th>
        <th scope="col">Name</th>
        <th scope="col">isActive</th>
        <th scope="col">Salary</th>
        <th scope="col">Company</th>
        <th scope="col">Operations</th>
        </tr>
    </thead>
    <tbody>
        <tr v-for=" (user, index ) in users.data" v-bind:key="index" >
        <td> {{ index +1 }} </td> 
        <td> {{ user.name }} </td>
        <td> {{ user.active }} </td> 
        <td> ${{ user.salary }} </td>
        <td> {{ user.company }}</td>  
        <td>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editUserModel" v-on:click="editUserBtn(user)"> <i class="fa fa-id-card" aria-hidden="true"></i> Edit</button>
            <button type="button" class="btn btn-danger" style="margin-left: 10px" v-on:click="deleteUser(user, index )" > <i class="fa fa-times" aria-hidden="true" ></i>   Delete</button>
        </td>
        </tr> 
    </tbody>
    </table>  

     <!-- model for add user -->
    <div class="modal fade" id="addUserModel" tabindex="-1" role="dialog" aria-labelledby="addUserModelLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="addUserModelLabel">Add a User</h5> 
        </div>
        <div class="modal-body"> 
            <form>
                <div class="form-group">
                    <label for="Name">Name</label>
                    <input type="text" v-model="user1.name" class="form-control" id="Name"  placeholder="Enter Name">
                </div>
                <div class="form-group">
                    <label for="Company">Company</label>
                    <input type="text" v-model="user1.company" class="form-control" id="Company" placeholder="Enter Company">
                </div>
                 <div class="form-group">
                    <label for="Salary">Salary ($)</label>
                    <input type="number" v-model="user1.salary" class="form-control" id="Salary" placeholder="Enter Salary">
                </div> 
            </form> 
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal"> <i class="fa fa-times" aria-hidden="true" ></i> Close</button>
            <button type="button" class="btn btn-primary" v-on:click="addUser()" data-dismiss="modal"> <i class="fa fa-plus" aria-hidden="true"></i> Add</button>
        </div>
        </div>
    </div>
    </div>

    <!-- model for edit user -->
    <div class="modal fade" id="editUserModel" tabindex="-1" role="dialog" aria-labelledby="editUserModel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="editUserModelLabel">Edit a User</h5> 
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group">
                    <label for="Name">Name</label>
                    <input type="text" v-model="user.name" class="form-control" id="Name" readonly>
                </div>
                 <div class="form-group">
                    <label for="Salary">Salary ($)</label>
                    <input type="number" v-model="user.salary" class="form-control" id="Salary">
                </div> 
            </form> 
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal"><i class="fa fa-times" aria-hidden="true" ></i> Close</button>
            <button type="button" class="btn btn-primary" v-on:click="editUser()"  data-dismiss="modal"><i class="fa fa-star" aria-hidden="true"></i> Save changes</button>
        </div>
        </div>
    </div>
    </div>

  </div>
</template>

<script>
import axios from 'axios';

const baseURL = "http://localhost:8081/users";

export default {

  props: {
    msg: String
  },
  data() {
            return {
                isHidden: true,
                users: [],
                
                user : {
                    id:"",
                    name: "",
                    salary: "",
                    company: "",
                    active: true
                },

                user1 : {
                    id:"",
                    name: "",
                    salary: "",
                    company: "",
                    active: true
                }
            };
        },

    mounted () {   
        this.getAllUsers();
    },

    methods : {

    getAllUsers() {  
        axios.get(baseURL.concat('/findAll'))
        .then(response => {
        this.users = response.data;
        console.log(this.users.data);
        })
        .catch(e => {
        this.errors.push(e);
        })
    },
  
    deleteUser(user, id) {  
        axios.delete(baseURL.concat('/delete/').concat( this.users.data[id].id))
        .then(response => { 
            console.log(response);
            this.getAllUsers();
        });
        },

    addUser() {    
        
        this.user1.id = this.users.data[this.users.data.length - 1 ].id + Math.floor(Math.random() * 10) ; //get last user id and add random number
        axios.post(baseURL, this.user1)
        .then(response => { 
            console.log(response);
            this.getAllUsers(); 
            this.user = new Object();       
        });
        },

    editUserBtn(user) {
            this.user = user;
        },

    editUser() {  
        console.log(this.user);
        axios.put(baseURL, this.user)
        .then(response => { 
            console.log(response);
            this.getAllUsers();
            this.user = new Object();    
        });
        },

    }
}
</script> 

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
