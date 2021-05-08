package edu.tcu.cs.controller;

import edu.tcu.cs.domain.Result;
import edu.tcu.cs.domain.StatusCode;
import edu.tcu.cs.domain.User;
import edu.tcu.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Result findAll() {
        final List<User> users = userService.findAll();
        return new Result(StatusCode.SUCCESS, "Find All Success", users);
    }

    @RequestMapping("/findOne/{id}")
    @ResponseBody
    public Result getProduct(@PathVariable String id) {
        User user = userService.findById(id);
        return new Result(StatusCode.SUCCESS, "Find One Product Success", user);
    }

    @PutMapping
    @ResponseBody
    public Result update(@RequestBody User user) {

        User updatedUser = userService.save(user);

        return new Result(StatusCode.SUCCESS, "User Updated!", updatedUser);
    }

    @PostMapping
    @ResponseBody
    public Result save(@RequestBody User user) {

        User savedUser = userService.save(user);

        return new Result(StatusCode.SUCCESS, "User Saved!", savedUser);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable String id) {
        userService.delete(id);
        return new Result(StatusCode.SUCCESS, "User Deleted!", null);
    }
}
