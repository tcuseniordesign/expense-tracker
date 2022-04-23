package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.User;
import edu.tcu.cs.expensetracker.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ActivityDao activityDao;

    private UserService userService;

    public DBDataInitializer(ActivityDao activityDao, UserService userService) {
        this.activityDao = activityDao;

        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setId("1250808601736515584");
        a1.setName("John ");
        a1.setDescription(" deposit");
        a1.setAccount("Checking");
        a1.setCreatetime("10/21/22");
        a1.setMoney(50);

        Activity a2 = new Activity();
        a2.setId("1250808601744904193");
        a2.setName("John ");
        a2.setDescription("Widthdrawel");
        a2.setAccount("Checking");
        a2.setCreatetime("10/21/22");
        a2.setMoney(50);




        // Since a6 doesn't have an owner yet, we need to save it explicitly here
        activityDao.save(a1);
        activityDao.save(a2);



        // create some users
        User u1 = new User();
        u1.setUsername("john");
        u1.setPassword("123456");
        u1.setEnabled(true);
        u1.setRoles("admin");

        User u2 = new User();
        u2.setUsername("eric");
        u2.setPassword("654321");
        u2.setEnabled(true);
        u2.setRoles("user");

        User u3 = new User();
        u3.setUsername("tom");
        u3.setPassword("qwerty");
        u3.setEnabled(false);
        u3.setRoles("user");

        userService.save(u1);
        userService.save(u2);
        userService.save(u3);

    }
}
