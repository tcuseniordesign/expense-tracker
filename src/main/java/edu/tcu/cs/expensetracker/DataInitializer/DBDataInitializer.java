package edu.tcu.cs.expensetracker.DataInitializer;


import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activities;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception {

        Activities a1 = new Activities();
        a1.setId("1");
        a1.setName("Dining Spending");
        a1.setMoney("247");
        a1.setAccount("ChaseBank Credit Card");
        a1.setCreationTime(new Date(2016, 03, 02));
        a1.setDescription("Dutch Burger");


        Activities a2 = new Activities();
        a2.setId("2");
        a2.setName("Salary Income");
        a2.setMoney("3000");
        a2.setAccount("Cash");
        a2.setCreationTime(new Date(2016, 03, 15));
        a2.setDescription("Dutch Burger");

        Activities a3 = new Activities();
        a3.setId("3");
        a3.setName("Dining Spending");
        a3.setMoney("247");
        a3.setAccount("ChaseBank Credit Card");
        a3.setCreationTime(new Date(2016, 04, 02));
        a3.setDescription("Dutch Burger");

        Activities a4 = new Activities();
        a4.setId("4");
        a4.setName("Dining Spending");
        a4.setMoney("247");
        a4.setAccount("ChaseBank Credit Card");
        a4.setCreationTime(new Date(2016, 06, 18));
        a4.setDescription("Dutch Burger");

        Activities a5 = new Activities();
        a5.setId("5");
        a5.setName("Dining Spending");
        a5.setMoney("247");
        a5.setAccount("ChaseBank Credit Card");
        a5.setCreationTime(new Date(2016, 10, 28));
        a5.setDescription("Dutch Burger");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);

    }
}
