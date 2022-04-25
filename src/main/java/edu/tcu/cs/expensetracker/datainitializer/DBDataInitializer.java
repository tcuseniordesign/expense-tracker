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
        a1.setName("Shopping");
        a1.setDescription("Shopped at the Gucci store");
        a1.setMoney(5000.00);
        a1.setCreateTime(LocalDate.of(2022,4,24));
        a1.setAccount("Checkings");

        Activity a2 = new Activity();
        a2.setName("Rent");
        a2.setDescription("Monthly rent");
        a2.setMoney(2500.00);
        a2.setCreateTime(LocalDate.of(2022,4,24));
        a2.setAccount("Checkings");

        Activity a3 = new Activity();
        a3.setName("Tuition");
        a3.setDescription("Semester tuition");
        a3.setMoney(15000.00);
        a3.setCreateTime(LocalDate.of(2022,4,24));
        a3.setAccount("Checkings");

        Activity a4 = new Activity();
        a4.setName("Credit Card");
        a4.setDescription("Monthly credit card bill");
        a4.setMoney(2500.00);
        a4.setCreateTime(LocalDate.of(2022,4,24));
        a4.setAccount("Savings");

        Activity a5 = new Activity();
        a5.setName("Credit Card");
        a5.setDescription("Monthly credit card bill");
        a5.setMoney(2500.00);
        a5.setCreateTime(LocalDate.of(2022,4,24));
        a5.setAccount("Savings");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}