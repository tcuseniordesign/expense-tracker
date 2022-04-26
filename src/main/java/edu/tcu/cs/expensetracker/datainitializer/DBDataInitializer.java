package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBDataInitializer implements CommandLineRunner {

    ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception{
        Activity a1 = new Activity();
        a1.setName("Groceries");
        a1.setDescription("Central Market");
        a1.setMoney(150.00);
        a1.setCreateTime(LocalDate.of(2022,4,25));
        a1.setAccount("Checking");

        Activity a2 = new Activity();
        a2.setName("Shopping");
        a2.setDescription("Nike Store");
        a2.setMoney(1000.00);
        a2.setCreateTime(LocalDate.of(2022,4,25));
        a2.setAccount("Checking");

        Activity a3 = new Activity();
        a3.setName("Rent");
        a3.setDescription("Monthly Rent");
        a3.setMoney(1100.00);
        a3.setCreateTime(LocalDate.of(2022,4,25));
        a3.setAccount("Checking");

        Activity a4 = new Activity();
        a4.setName("Miscellaneous");
        a4.setDescription("Spelunking");
        a4.setMoney(2000.00);
        a4.setCreateTime(LocalDate.of(2022,4,25));
        a4.setAccount("Savings");

        Activity a5 = new Activity();
        a5.setName("Credit Card");
        a5.setDescription("Monthly bill");
        a5.setMoney(1500.00);
        a5.setCreateTime(LocalDate.of(2022,4,25));
        a5.setAccount("Savings");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}