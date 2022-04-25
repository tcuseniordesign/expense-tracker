package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception{
        Activity a1 = new Activity();
        a1.setName("Dining Spending");
        a1.setMoney(247.00);
        a1.setAccount("ChaseBank Credit Card");
        a1.setCreateTime(LocalDate.of(2016,3,2));
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        a2.setName("Salary Income");
        a2.setMoney(3000.00);
        a2.setAccount("Cash");
        a2.setCreateTime(LocalDate.of(2016,3,15));
        a2.setDescription("September Salary");

        Activity a3 = new Activity();
        a3.setName("Books Spending");
        a3.setMoney(200.00);
        a3.setAccount("Cash");
        a3.setCreateTime(LocalDate.of(2016,4,2));
        a3.setDescription("Calculus Book");

        Activity a4 = new Activity();
        a4.setName("Dining Spending");
        a4.setMoney(325.00);
        a4.setAccount("Cash");
        a4.setCreateTime(LocalDate.of(2016,6,18));
        a4.setDescription("Eat at TCU Cafe");

        Activity a5 = new Activity();
        a5.setName("Stock Income");
        a5.setMoney(8000.00);
        a5.setAccount("'WellsFargo Saving Account");
        a5.setCreateTime(LocalDate.of(2016,10,28));
        a5.setDescription("Apple Stock is great!");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
