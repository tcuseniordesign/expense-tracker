package edu.tcu.cs.expensetracker.datainitalizer;

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
        a1.setId("100");
        a1.setName("Dining Spending");
        a1.setMoney(247);
        a1.setAccount("ChaseBank Credit Card");
        a1.setCreatetime("2016-03-02");
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        a2.setId("101");
        a2.setName("Salary Income");
        a2.setMoney(3000);
        a2.setAccount("Cash");
        a2.setCreatetime("2016-03-15");
        a2.setDescription("September Salary");

        Activity a3 = new Activity();
        a3.setId("102");
        a3.setName("Books Spending");
        a3.setMoney(200);
        a3.setAccount("Cash");
        a3.setCreatetime("2016-04-02");
        a3.setDescription("Calculus Book");

        Activity a4 = new Activity();
        a4.setId("103");
        a4.setName("Stock Income");
        a4.setMoney(8000);
        a4.setAccount("WellsFargo Saving Account");
        a4.setCreatetime("2016-10-28");
        a4.setDescription("Apple Stock is great!");

        Activity a5 = new Activity();
        a5.setId("104");
        a5.setName("Flight Ticket Spending");
        a5.setMoney(500);
        a5.setAccount("ChaseBank Debit Card");
        a5.setCreatetime("2016-10-30");
        a5.setDescription("Fly to LV");
        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
