package edu.tcu.cs.expensetracker.DBDataInitializer;


import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setId("1");
        a1.setName("Dining Spending");
        a1.setMoney(247);
        a1.setCreatetime("2016-02-03");
        a1.setDescription("Dutch Burger");
        a1.setAccount("Chase Credit Card");

        Activity a2 = new Activity();
        a2.setId("2");
        a2.setName("Investing");
        a2.setMoney(500);
        a2.setCreatetime("2016-02-05");
        a2.setDescription("Apple Stock");
        a2.setAccount("Cash");

        Activity a3 = new Activity();
        a3.setId("3");
        a3.setName("Gas Spending");
        a3.setMoney(420);
        a3.setCreatetime("2016-02-07");
        a3.setDescription("Gas");
        a3.setAccount("Cash");

        Activity a4 = new Activity();
        a4.setId("4");
        a4.setName("Salary Income");
        a4.setMoney(1500);
        a4.setCreatetime("2017-04-08");
        a4.setDescription("Salary");
        a4.setAccount("Debit");

        Activity a5 = new Activity();
        a5.setId("5");
        a5.setName("Flight Ticket Spending");
        a5.setMoney(4500);
        a5.setCreatetime("2016-05-09");
        a5.setDescription("Flight Ticket");
        a5.setAccount("WellsFargo Saving");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
