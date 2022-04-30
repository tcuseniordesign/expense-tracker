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
        Activity a2 = new Activity();
        Activity a3 = new Activity();

//        a1.setId(1);
        a1.setName("Clothes Spending");
        a1.setMoney(5000.0);
        a1.setAccount("Cash");
        a1.setDate("2016-10-28");
        a1.setDescription("JCrew again");

//        a2.setId(2);
        a2.setName("Flight Ticket Spending");
        a2.setMoney(500.0);
        a2.setAccount("ChaseBank Debit Card");
        a2.setDate("2016-10-30");
        a2.setDescription("Fly to LA");

//        a3.setId(3);
        a3.setName("Salary Income");
        a3.setMoney(3000.0);
        a3.setAccount("Cash");
        a3.setDate("2016-03-15");
        a3.setDescription("September Salary");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);

    }
}