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
        a1.setName("Dining Spending");
        a1.setDescription("Dutch Burger");
        a1.setMoney(247.00);
        a1.setCreateTime(LocalDate.of(2022,3,2));
        a1.setAccount("ChaseBank Credit Card");

        Activity a2 = new Activity();
        a2.setName("Salary Income");
        a2.setDescription("September Salary");
        a2.setMoney(3000.00);
        a2.setCreateTime(LocalDate.of(2021,9,30));
        a2.setAccount("Cash");

        Activity a3 = new Activity();
        a3.setName("Gas Spending");
        a3.setDescription("Gas is so expensive");
        a3.setMoney(1200.00);
        a3.setCreateTime(LocalDate.of(2022,4,20));
        a3.setAccount("ChaseBack Credit Card");

        Activity a4 = new Activity();
        a4.setName("Books Spending");
        a4.setDescription("Calculus Book");
        a4.setMoney(200.00);
        a4.setCreateTime(LocalDate.of(2022,1,21));
        a4.setAccount("Cash");

        Activity a5 = new Activity();
        a5.setName("Flight Ticket Spending");
        a5.setDescription("Fly to India");
        a5.setMoney(1578.00);
        a5.setCreateTime(LocalDate.of(2022,5,10));
        a5.setAccount("WellFargo Checking Account");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}