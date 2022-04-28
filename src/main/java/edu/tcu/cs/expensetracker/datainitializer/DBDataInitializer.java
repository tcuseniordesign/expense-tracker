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
        a1.setName("Dining Spending");
        a1.setMoney(247);
        a1.setAccount("ChaseBank Credit Card");
        a1.setCreatetime("2016-03-02");
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        a2.setName("Salary Income");
        a2.setMoney(3000);
        a2.setAccount("Cash");
        a2.setCreatetime("2016-03-15");
        a2.setDescription("September Salary");

        Activity a3 = new Activity();
        a3.setName("Books Spending");
        a3.setMoney(200);
        a3.setAccount("Cash");
        a3.setCreatetime("2016-04-02");
        a3.setDescription("Calculus Book");

        Activity a4 = new Activity();
        a4.setName("Dining Spending");
        a4.setMoney(335);
        a4.setAccount("Cash");
        a4.setCreatetime("2016-06-18");
        a4.setDescription("Eat At TCU Cafe");

        Activity a5 = new Activity();
        a5.setName("Stock Income");
        a5.setMoney(8000);
        a5.setAccount("WellsFargo Saving Account");
        a5.setCreatetime("2016-10-28");
        a5.setDescription("Apple Stock is great!");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);

    }
}
