package edu.tcu.cs.expensetracker.datainitializer;

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
        a1.setId(1);
        a1.setName("Salary income");
        a1.setAccount("Cash");
        a1.setMoney(200.00);
        a1.setCreatTime("2016-03-02");
        a1.setDescription("buy stuff");

        Activity a2 = new Activity();
        a2.setId(2);
        a2.setName("Dinner");
        a2.setAccount("Bank of America");
        a2.setMoney(2000.50);
        a2.setCreatTime("2017-05-06");
        a2.setDescription("buy more stuff");

        Activity a3 = new Activity();
        a3.setId(3);
        a3.setName("Clothes");
        a3.setAccount("Credit card");
        a3.setMoney(50.00);
        a3.setCreatTime("2016-03-10");
        a3.setDescription("pants");

        Activity a4 = new Activity();
        a4.setId(4);
        a4.setName("Lunch");
        a4.setAccount("Debit card");
        a4.setMoney(12.50);
        a4.setCreatTime("2018-04-21");
        a4.setDescription("chicken sandwhich");

        Activity a5 = new Activity();
        a5.setId(5);
        a5.setName("Income");
        a5.setAccount("Bank of America");
        a5.setMoney(2000000.00);
        a5.setCreatTime("2020-04-29");
        a5.setDescription("Pay day");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
