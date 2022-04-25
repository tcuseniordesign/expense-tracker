package edu.tcu.cs.expensetracker.dbinitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBInitializer implements CommandLineRunner {

    private ActivityDao activityDao;

    public DBInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setId(1);
        a1.setName("Dining Spending");
        a1.setMoney(247.50);
        a1.setAccount("Chase Bank Credit Card");
        a1.setCreatetime(LocalDate.of(2016,4,24));
        a1.setDescription("Dutches");

        Activity a2 = new Activity();
        a2.setId(2);
        a2.setName("Salary Income");
        a2.setMoney(3000.00);
        a2.setAccount("Cash");
        a2.setCreatetime(LocalDate.of(2016,6,02));
        a2.setDescription("September Salary");

        Activity a3 = new Activity();
        a3.setId(3);
        a3.setName("Books Spending");
        a3.setMoney(200.00);
        a3.setAccount("Cash");
        a3.setCreatetime(LocalDate.of(2016,1,12));
        a3.setDescription("Calculus Book");

        Activity a4 = new Activity();
        a4.setId(4);
        a4.setName("Clothes Spending");
        a4.setMoney(500.00);
        a4.setAccount("Cash");
        a4.setCreatetime(LocalDate.of(2016,9,14));
        a4.setDescription("JCrew");

        Activity a5 = new Activity();
        a5.setId(5);
        a5.setName("Gas Spending");
        a5.setMoney(1200.00);
        a5.setAccount("ChaseBank Credit Card");
        a5.setCreatetime(LocalDate.of(2016,3,24));
        a5.setDescription("So much gas money");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
