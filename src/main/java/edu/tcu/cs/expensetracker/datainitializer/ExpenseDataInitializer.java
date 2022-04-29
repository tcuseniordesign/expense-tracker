package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import edu.tcu.cs.expensetracker.domain.Expense;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExpenseDataInitializer implements CommandLineRunner {

    private ExpenseDao expenseDao;

    public ExpenseDataInitializer(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Expense e1 = new Expense();
        e1.setId("1");
        e1.setName("Dining Spending");
        e1.setMoney("247");
        e1.setAccount("Chase Bank");
        e1.setCreateTime("2016-03-02");
        e1.setDescription("Dutch Burger");

        Expense e2 = new Expense();
        e2.setId("2");
        e2.setName("Salary Income");
        e2.setMoney("3000");
        e2.setAccount("Cash");
        e2.setCreateTime("2016-03-15");
        e2.setDescription("September Salary");

        Expense e3 = new Expense();
        e3.setId("3");
        e3.setName("Books Spending");
        e3.setMoney("200");
        e3.setAccount("Cash");
        e3.setCreateTime("2016-04-02");
        e3.setDescription("Calculus Book");

        Expense e4 = new Expense();
        e4.setId("4");
        e4.setName("Dining Spending");
        e4.setMoney("325");
        e4.setAccount("Cash");
        e4.setCreateTime("2016-06-18");
        e4.setDescription("Eat at TCU Cafe");

        Expense e5 = new Expense();
        e5.setId("5");
        e5.setName("Stock Income");
        e5.setMoney("8000");
        e5.setAccount("WellsFargo Saving Account");
        e5.setCreateTime("2016-10-28");
        e5.setDescription("Apple Stock is great!");

        Expense e6 = new Expense();
        e6.setId("6");
        e6.setName("Stock Income");
        e6.setMoney("5000");
        e6.setAccount("WellsFargo Saving Account");
        e6.setCreateTime("2016-10-28");
        e6.setDescription("Oracle Stock is great!");

        Expense e7 = new Expense();
        e7.setId("7");
        e7.setName("Stock Income");
        e7.setMoney("3000");
        e7.setAccount("ChaseBank Saving Account");
        e7.setCreateTime("2016-10-28");
        e7.setDescription("Oct Salary time!");

        Expense e8 = new Expense();
        e8.setId("8");
        e8.setName("Clothes Spending");
        e8.setMoney("5000");
        e8.setAccount("Cash");
        e8.setCreateTime("2016-10-28");
        e8.setDescription("JCrew again");

        Expense e9 = new Expense();
        e9.setId("9");
        e9.setName("Other Spending");
        e9.setMoney("20");
        e9.setAccount("Cash");
        e9.setCreateTime("2016-10-29");
        e9.setDescription("Lost 20 bucks in library. :(");

        Expense e10 = new Expense();
        e10.setId("10");
        e10.setName("Gas Spending");
        e10.setMoney("1200");
        e10.setAccount("ChaseBank Credit Card");
        e10.setCreateTime("2016-10-29");
        e10.setDescription("Gas is so expensive");

        Expense e11 = new Expense();
        e11.setId("11");
        e11.setName("Dining Spending");
        e11.setMoney("1000");
        e11.setAccount("ChaseBank Debit Card");
        e11.setCreateTime("2016-10-29");
        e11.setDescription("Eat eat eat");

        Expense e12 = new Expense();
        e12.setId("12");
        e12.setName("Salary Income");
        e12.setMoney("3000");
        e12.setAccount("ChaseBank Saving Account");
        e12.setCreateTime("2016-10-30");
        e12.setDescription("Nov salary");

        Expense e13 = new Expense();
        e13.setId("13");
        e13.setName("Flight Ticket Spending");
        e13.setMoney("500");
        e13.setAccount("ChaseBank Debit Card");
        e13.setCreateTime("2016-10-30");
        e13.setDescription("Fly to LA");

        Expense e14 = new Expense();
        e14.setId("14");
        e14.setName("Salary Income");
        e14.setMoney("3000");
        e14.setAccount("ChaseBank Saving Account");
        e14.setCreateTime("2016-10-30");
        e14.setDescription("December Salary");

        expenseDao.save(e1);
        expenseDao.save(e2);
        expenseDao.save(e3);
        expenseDao.save(e4);
        expenseDao.save(e5);
        expenseDao.save(e6);
        expenseDao.save(e7);
        expenseDao.save(e8);
        expenseDao.save(e9);
        expenseDao.save(e10);
        expenseDao.save(e11);
        expenseDao.save(e12);
        expenseDao.save(e13);
        expenseDao.save(e14);
    }
}
