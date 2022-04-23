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
        a1.setName("Food");
        a1.setDescription("Resturant");
        a1.setMoney(50.00);
        a1.setCreateTime(LocalDate.of(2022,4,20));
        a1.setAccount("Checking");

        Activity a2 = new Activity();
        a2.setName("Grocery");
        a2.setDescription("Store");
        a2.setMoney(100.00);
        a2.setCreateTime(LocalDate.of(2022,4,21));
        a2.setAccount("Credit");

        Activity a3 = new Activity();
        a3.setName("Gas");
        a3.setDescription("FlyingJ");
        a3.setMoney(2000.00);
        a3.setCreateTime(LocalDate.of(2022,4,20));
        a3.setAccount("Checking");

        Activity a4 = new Activity();
        a4.setName("Tuition");
        a4.setDescription("TCU");
        a4.setMoney(25000.00);
        a4.setCreateTime(LocalDate.of(2022,4,21));
        a4.setAccount("Savings");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
    }
}