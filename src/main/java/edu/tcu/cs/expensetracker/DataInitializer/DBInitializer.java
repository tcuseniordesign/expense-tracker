package edu.tcu.cs.expensetracker.DataInitializer;

import edu.tcu.cs.expensetracker.Domain.Activity;
import edu.tcu.cs.expensetracker.Repositories.ActivityDao;
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
        a1.setName("Salary Income");
        a1.setAccount("Cash");
        a1.setMoney(3000.0);
        LocalDate date1 = LocalDate.parse("2016-03-15");
        a1.setCreatetime(date1);
        a1.setDescription("September Salary");

        Activity a2 = new Activity();
        a2.setId(2);
        a2.setName("Books Spending");
        a2.setAccount("Cash");
        a2.setMoney(250.0);
        LocalDate date2 = LocalDate.parse("2016-04-02");
        a2.setCreatetime(date2);
        a2.setDescription("School Books");

        Activity a3 = new Activity();
        a3.setId(3);
        a3.setName("Stock Income");
        a3.setAccount("WellsFargo Saving Account");
        a3.setMoney(8599.0);
        LocalDate date3 = LocalDate.parse("2016-10-28");
        a3.setCreatetime(date3);
        a3.setDescription("TESLA BABY");

        Activity a4 = new Activity();
        a4.setId(4);
        a4.setName("Clothes Spending");
        a4.setAccount("Cash");
        a4.setMoney(10000.0);
        LocalDate date4 = LocalDate.parse("2016-09-04");
        a4.setCreatetime(date4);
        a4.setDescription("I want to be a JCrew model");

        Activity a5 = new Activity();
        a5.setId(5);
        a5.setName("Plane Ticket");
        a5.setAccount("ChaseBank Credit Card");
        a5.setMoney(3000.0);
        LocalDate date5 = LocalDate.parse("2016-09-10");
        a5.setCreatetime(date5);
        a5.setDescription("Visit Grandma");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
