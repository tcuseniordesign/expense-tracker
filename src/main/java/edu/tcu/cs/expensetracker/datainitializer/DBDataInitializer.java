package edu.tcu.cs.expensetracker.datainitializer;
import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DBDataInitializer implements CommandLineRunner {

    public ActivityDao activityDao;

    public DBDataInitializer(ActivityDao artifactDao) {
        this.activityDao = artifactDao;
    }

    @Override
    public void run(String... args) throws Exception{
        Activity a1 = new Activity();
        a1.setId("1");
        a1.setName("Dining Spending");
        a1.setAccount("ChaseBank Credit Card");
        a1.setMoney(247.0);
        a1.setTime("2016-03-02");
        a1.setDescription("Dutch Burger");

        Activity a2 = new Activity();
        a2.setId("2");
        a2.setName("Salary Income");
        a2.setAccount("Cash");
        a2.setMoney(3000.0);
        a2.setTime("2016-03-15");
        a2.setDescription("September Salary");

        Activity a3 = new Activity();
        a3.setId("3");
        a3.setName("Books Spending");
        a3.setMoney(200.00);
        a3.setAccount("Cash");
        a3.setTime("2016-04-02");
        a3.setDescription("Calculus Book");

        Activity a4 = new Activity();
        a4.setId("4");
        a4.setName("Dining Spending");
        a4.setMoney(325.00);
        a4.setAccount("Cash");
        a4.setTime("2016-06-18");
        a4.setDescription("TCU cafe");

        Activity a5 = new Activity();
        a5.setId("5");
        a5.setName("Stock Income");
        a5.setMoney(8000.00);
        a5.setAccount("Wells Fargo Account");
        a5.setTime("2016-10-28");
        a5.setDescription("Apple stock");


        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);
    }
}
