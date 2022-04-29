package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.apache.tomcat.jni.Local;
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
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setName("Dining Spending");
        a1.setDescription("Dutch Burger");
        a1.setMoney(247.00);
        a1.setCreateTime(LocalDate.of(2016,03,02));
        a1.setAccount("ChaseBank Credit Card");

        Activity a2 = new Activity();
        a2.setName("Salary Income");
        a2.setDescription("September Salary");
        a2.setMoney(3000.00);
        a2.setCreateTime(LocalDate.of(2016,03,15));
        a2.setAccount("Cash");

        Activity a3 = new Activity();
        a3.setName("Books Spending");
        a3.setDescription("Calculus Book");
        a3.setMoney(200.00);
        a3.setCreateTime(LocalDate.of(2016,04,02));
        a3.setAccount("Cash");

        Activity a4 = new Activity();
        a4.setName("Stock Income");
        a4.setDescription("Apple Stock is great!");
        a4.setMoney(8000.00);
        a4.setCreateTime(LocalDate.of(2016,10,28));
        a4.setAccount("WellsFargo Saving Account");

        Activity a5 = new Activity();
        a5.setName("Clothes Spending");
        a5.setDescription("JCrew again");
        a5.setMoney(5000.00);
        a5.setCreateTime(LocalDate.of(2016,10,28));
        a5.setAccount("Cash");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
