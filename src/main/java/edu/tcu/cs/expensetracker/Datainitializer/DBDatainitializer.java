package edu.tcu.cs.expensetracker.Datainitializer;

import edu.tcu.cs.expensetracker.Dao.ActivityDao;
import edu.tcu.cs.expensetracker.Domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDatainitializer implements CommandLineRunner {

    private final ActivityDao activityDao;

    public DBDatainitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setId(1);
        a1.setName("Dining Spending");
        a1.setMoney(247.00);
        a1.setAccount("ChaseBank Credit Card");
        a1.setDate("2016-03-02");
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        Activity a3 = new Activity();

        a2.setId(2);
        a2.setName("Salary Income");
        a2.setMoney(3000.0);
        a2.setAccount("Cash");
        a2.setDate("2016-03-15");
        a2.setDescription("September Salary");

        a3.setId(3);
        a3.setName("Books Spending");
        a3.setMoney(200.0);
        a3.setAccount("Cash");
        a3.setDate("2016-04-02");
        a3.setDescription("Calculus Book");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);

    }
}

