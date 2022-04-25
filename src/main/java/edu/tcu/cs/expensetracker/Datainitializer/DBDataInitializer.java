package edu.tcu.cs.expensetracker.Datainitializer;

import edu.tcu.cs.expensetracker.Dao.ActivityDao;
import edu.tcu.cs.expensetracker.Domain.Activity;
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
        a1.setName("Clothing");
        a1.setDescription("New shirt");
        a1.setMoney(123.00);
        a1.setCreateTime(LocalDate.of(2022,2,26));
        a1.setAccount("Checking");

        Activity a2 = new Activity();
        a2.setName("Groceries");
        a2.setDescription("Food for two weeks");
        a2.setMoney(170.00);
        a2.setCreateTime(LocalDate.of(2022,3,3));
        a2.setAccount("Checking");

        Activity a3 = new Activity();
        a3.setName("Netflix");
        a3.setDescription("Monthly bill for Netflix no ads");
        a3.setMoney(2000.00);
        a3.setCreateTime(LocalDate.of(2022,3,20));
        a3.setAccount("Checking");

        Activity a4 = new Activity();
        a4.setName("Gas Pump");
        a4.setDescription("Gas for my car to drive");
        a4.setMoney(200.00);
        a4.setCreateTime(LocalDate.of(2022,3,15));
        a4.setAccount("Credit");

        Activity a5 = new Activity();
        a5.setName("Rent");
        a5.setDescription("Rent to live in my home");
        a5.setMoney(1200.00);
        a5.setCreateTime(LocalDate.of(2022,4,1));
        a5.setAccount("Savings");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}