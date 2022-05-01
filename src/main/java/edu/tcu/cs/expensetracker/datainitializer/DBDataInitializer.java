package edu.tcu.cs.expensetracker.datainitializer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;



@Component
public class DBDataInitializer implements CommandLineRunner{

    private ActivityDao dao;

    public DBDataInitializer(ActivityDao dao) {
        this.dao = dao;
    }
    
    
    

    @Override
    public void run(String... args) throws Exception {
        
        Activity a1 = new Activity();
        a1.setId(1);
        a1.setName("Salary Income");
        a1.setMoney(3000);
        a1.setAccount("BingusBank Checking Account");
        a1.setCreatetime("2022-04-30");
        a1.setDescription("I really need to go to bed sooner...");

        Activity a2 = new Activity();
        a2.setId(2);
        a2.setName("Taxes");
        a2.setMoney(3000);
        a2.setAccount("FunPolice Credit Card");
        a2.setCreatetime("2022-04-31");
        a2.setDescription("no seriously its like 5:30 right now...");

        Activity a3 = new Activity();
        a3.setId(3);
        a3.setName("Flight Ticket Spending");
        a3.setMoney(300);
        a3.setAccount("Cash");
        a3.setCreatetime("2022-05-30");
        a3.setDescription("my sleep schedule is in shambles...");

        Activity a4 = new Activity();
        a4.setId(4);
        a4.setName("Salary Income");
        a4.setMoney(1);
        a4.setAccount("Cash");
        a4.setCreatetime("20222-04-30");
        a4.setDescription("Found a dollar on the sidewalk");

        dao.save(a1);
        dao.save(a2);
        dao.save(a3);
        dao.save(a4);
        
    }

    
}
