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

        activityDao.save(a1);
        activityDao.save(a2);
    }
}
