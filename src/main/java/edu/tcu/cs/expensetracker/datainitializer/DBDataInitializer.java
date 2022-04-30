package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.service.ActivityService;
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
        a1.setMoney(100.99);
        a1.setAccount("ChaseBank Credit Card");
        a1.setCreatetime("2022-01-11");
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        a2.setId("2");
        a2.setName("Salary");
        a2.setMoney(200.99);
        a2.setAccount("Cash");
        a2.setCreatetime("2022-02-11");
        a2.setDescription("Money from Job");

        Activity a3 = new Activity();
        a3.setId("3");
        a3.setName("Books Spending");
        a3.setMoney(55.00);
        a3.setAccount("Cash");
        a3.setCreatetime("2022-03-11");
        a3.setDescription("Money on Books");

        Activity a4 = new Activity();
        a4.setId("4");
        a4.setName("Gas Spending");
        a4.setMoney(400.00);
        a4.setAccount("Cash");
        a4.setCreatetime("2021-02-11");
        a4.setDescription("Money for Gas");

        Activity a5 = new Activity();
        a5.setId("5");
        a5.setName("Stock Income");
        a5.setMoney(900.00);
        a5.setAccount("Cash");
        a5.setCreatetime("2021-07-11");
        a5.setDescription("Money from Stocks");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
