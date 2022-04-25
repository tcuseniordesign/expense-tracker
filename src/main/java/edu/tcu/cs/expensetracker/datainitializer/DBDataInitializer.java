package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBDataInitializer implements CommandLineRunner {

    ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception{
        Activity a1 = new Activity();
        a1.setName("Groceries");
        a1.setDescription("Trader Joes");
        a1.setMoney(240.00);
        a1.setCreateTime(LocalDate.of(2022,1, 18));
        a1.setAccount("Debit");

        Activity a2 = new Activity();
        a2.setName("Rent");
        a2.setDescription("Rent Expense");
        a2.setMoney(800.00);
        a2.setCreateTime(LocalDate.of(2022,4, 10));
        a2.setAccount("Savings");

        Activity a3 = new Activity();
        a3.setName("Extra Spending");
        a3.setDescription("Shopping Spree");
        a3.setMoney(100.00);
        a3.setCreateTime(LocalDate.of(2022,3, 13));
        a3.setAccount("Debit");

        Activity a4 = new Activity();
        a4.setName("Gas");
        a4.setDescription("Gas Money");
        a4.setMoney(300.00);
        a4.setCreateTime(LocalDate.of(2022,4, 24));
        a4.setAccount("Debit");

        Activity a5 = new Activity();
        a5.setName("School Expenses");
        a5.setDescription("Books, Tutor, etc...");
        a5.setMoney(500.00);
        a5.setCreateTime(LocalDate.of(2022,1, 1));
        a5.setAccount("Debit");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);



    }
}
