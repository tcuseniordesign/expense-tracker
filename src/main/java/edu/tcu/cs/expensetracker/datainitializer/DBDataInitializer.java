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
        a1.setName("Salary");
        a1.setAccount("BoA");
        a1.setMoney(3000.00);
        a1.setCreateTime("2022-03-26");
        a1.setDescription("hard-earned cash");

        Activity a2 = new Activity();
        a2.setId(2);
        a2.setName("New Laptop");
        a2.setAccount("BoA");
        a2.setMoney(800.00);
        a2.setCreateTime("2022-04-06");
        a2.setDescription("Acer is great");

        Activity a3 = new Activity();
        a3.setId(3);
        a3.setName("Dinner");
        a3.setAccount("Cash");
        a3.setMoney(25.00);
        a3.setCreateTime("2022-04-10");
        a3.setDescription("Steakhouse");

        Activity a4 = new Activity();
        a4.setId(4);
        a4.setName("Books");
        a4.setAccount("BoA");
        a4.setMoney(451.50);
        a4.setCreateTime("2022-01-21");
        a4.setDescription("Books are expensive");

        Activity a5 = new Activity();
        a5.setId(5);
        a5.setName("Income");
        a5.setAccount("Cash");
        a5.setMoney(20.00);
        a5.setCreateTime("2022-04-29");
        a5.setDescription("Money Tommy owed mey");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
