package edu.tcu.cs.datainitializer;

import edu.tcu.cs.domain.User;
import edu.tcu.cs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class DBDataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        loadData();

    }

    private void loadData() {

        // create some users
        User u1 = new User();
        u1.setId(UUID.randomUUID().toString());
        u1.setActive(false);
        u1.setSalary(1878.32);
        u1.setPicture("http://placehold.it/32x32");
        u1.setAge(34);
        u1.setEyeColor("brown");
        u1.setName("Jewel Sosa");
        u1.setGender("female");
        u1.setCompany("SIGNIDYNE");
        u1.setEmail("jewelsosa@signidyne.com");
        u1.setPhone("+1 (817) 538-2348");
        u1.setAddress("291 Kingston Avenue, Bannock, Washington, 8709");

        User u2 = new User();
        u2.setId(UUID.randomUUID().toString());
        u2.setActive(false);
        u2.setSalary(3559.88);
        u2.setPicture("http://placehold.it/32x32");
        u2.setAge(23);
        u2.setEyeColor("brown");
        u2.setName("Grimes Olsen");
        u2.setGender("male");
        u2.setCompany("YURTURE");
        u2.setEmail("grimesolsen@yurture.com");
        u2.setPhone("+1 (926) 502-3084");
        u2.setAddress("377 Danforth Street, Cleary, Virginia, 6123");

        User u3 = new User();
        u3.setId(UUID.randomUUID().toString());
        u3.setActive(true);
        u3.setSalary(2300.27);
        u3.setPicture("http://placehold.it/32x32");
        u3.setAge(33);
        u3.setEyeColor("brown");
        u3.setName("Velasquez Bennett");
        u3.setGender("male");
        u3.setCompany("FUTURITY");
        u3.setEmail("velasquezbennett@futurity.com");
        u3.setPhone("+1 (820) 452-3033");
        u3.setAddress("605 Metrotech Courtr, Retsof, Kentucky, 2629");

        User u4 = new User();
        u4.setId(UUID.randomUUID().toString());
        u4.setActive(false);
        u4.setSalary(2123.47);
        u4.setPicture("http://placehold.it/32x32");
        u4.setAge(38);
        u4.setEyeColor("green");
        u4.setName("Gayle Burt");
        u4.setGender("female");
        u4.setCompany("VURBO");
        u4.setEmail("gayleburt@vurbo.com");
        u4.setPhone("+1 (847) 419-3818");
        u4.setAddress("319 Highland Avenue, Elizaville, Arkansas, 273");

        User u5 = new User();
        u5.setId(UUID.randomUUID().toString());
        u5.setActive(true);
        u5.setSalary(2358.41);
        u5.setPicture("http://placehold.it/32x32");
        u5.setAge(32);
        u5.setEyeColor("blue");
        u5.setName("Lori Price");
        u5.setGender("female");
        u5.setCompany("GRUPOLI");
        u5.setEmail("loriprice@grupoli.com");
        u5.setPhone("+1 (915) 511-3754");
        u5.setAddress("904 Canal Avenue, Canoochee, Pennsylvania, 8762");

        User u6 = new User();
        u6.setId(UUID.randomUUID().toString());
        u6.setActive(false);
        u6.setSalary(3752.40);
        u6.setPicture("http://placehold.it/32x32");
        u6.setAge(31);
        u6.setEyeColor("green");
        u6.setName("Marissa Hines");
        u6.setGender("female");
        u6.setCompany("SNORUS");
        u6.setEmail("marissahines@snorus.com");
        u6.setPhone("+1 (870) 512-3865");
        u6.setAddress("326 Montieth Street, Stouchsburg, Guam, 5638");

        User u7 = new User();
        u7.setId(UUID.randomUUID().toString());
        u7.setActive(false);
        u7.setSalary(1792.48);
        u7.setPicture("http://placehold.it/32x32");
        u7.setAge(20);
        u7.setEyeColor("brown");
        u7.setName("Polly Payne");
        u7.setGender("female");
        u7.setCompany("STOCKPOST");
        u7.setEmail("pollypayne@stockpost.com");
        u7.setPhone("+1 (997) 501-2848");
        u7.setAddress("286 Canda Avenue, Yardville, Indiana, 5281");

        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
        userService.save(u5);
        userService.save(u6);
        userService.save(u7);

    }
}
