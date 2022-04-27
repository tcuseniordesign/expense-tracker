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

        activityDao.save(a1);

    }
}

