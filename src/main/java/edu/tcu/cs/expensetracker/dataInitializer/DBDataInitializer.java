package edu.tcu.cs.expensetracker.dataInitializer;

import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import edu.tcu.cs.expensetracker.domain.Expense;
import edu.tcu.cs.expensetracker.service.ExpenseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private ExpenseDao expenseService;

    public DBDataInitializer(ExpenseDao expenseService){
        this.expenseService = expenseService;
    }

    @Override
    public void run(String... args) throws Exception {
        Expense e1 = new Expense();
        Expense e2 = new Expense();
        Expense e3 = new Expense();
        Expense e4 = new Expense();
        Expense e5 = new Expense();
        Expense e6 = new Expense();
        Expense e7 = new Expense();
        Expense e8 = new Expense();
        Expense e9 = new Expense();
        Expense e10 = new Expense();
        Expense e11 = new Expense();
        Expense e12 = new Expense();
        Expense e13 = new Expense();
        Expense e14 = new Expense();

        e1.setId("0");
        e1.setName("Dining Spending");
        e1.setMoney(247);
        e1.setAccount("ChaseBank Credit Card");
        e1.setCreatetime("2016-03-02");
        e1.setDesc("Dutch Burger");

        e2.setId("1");
        e2.setName("Salary Income");
        e2.setMoney(3000);
        e2.setAccount("Cash");
        e2.setCreatetime("2016-03-15");
        e2.setDesc("September Salary");

        e3.setId("2");
        e3.setName("Books Spending");
        e3.setMoney(200);
        e3.setAccount("Cash");
        e3.setCreatetime("2016-04-02");
        e3.setDesc("Calculus Book");

        e4.setId("3");
        e4.setName("Dining Spending");
        e4.setMoney(325);
        e4.setAccount("Cash");
        e4.setCreatetime("2016-06-18");
        e4.setDesc("Eat at TCU Cafe");

        e5.setId("4");
        e5.setName("Stock Income");
        e5.setMoney(8000);
        e5.setAccount("WellsFargo Saving Account");
        e5.setCreatetime("2016-10-28");
        e5.setDesc("Apple Stock is great!");

        e6.setId("5");
        e6.setName("Stock Income");
        e6.setMoney(5000);
        e6.setAccount("WellsFargo Saving Account");
        e6.setCreatetime("2016-10-28");
        e6.setDesc("Oracle Stock is great!");

        e7.setId("6");
        e7.setName("Salary Income");
        e7.setMoney(3000);
        e7.setAccount("ChaseBank Saving Account");
        e7.setCreatetime("2016-10-28");
        e7.setDesc("Oct Salary time!");

        e8.setId("7");
        e8.setName("Clothes Spending");
        e8.setMoney(5000);
        e8.setAccount("Cash");
        e8.setCreatetime("2016-10-28");
        e8.setDesc("JCrew again");

        e9.setId("8");
        e9.setName("Other Spending");
        e9.setMoney(20);
        e9.setAccount("Cash");
        e9.setCreatetime("2016-10-29");
        e9.setDesc("Lost 20 bucks in library.");

        e10.setId("9");
        e10.setName("Gas Spending");
        e10.setMoney(1200);
        e10.setAccount("ChaseBank Credit Card");
        e10.setCreatetime("2016-10-29");
        e10.setDesc("Gas is so expensive");

        e11.setId("10");
        e11.setName("Dining Spending");
        e11.setMoney(1000);
        e11.setAccount("ChaseBank Debit Card");
        e11.setCreatetime("2016-10-29");
        e11.setDesc("Eat eat eat");

        e12.setId("11");
        e12.setName("Salary Income");
        e12.setMoney(3000);
        e12.setAccount("ChaseBank Saving Account");
        e12.setCreatetime("2016-10-30");
        e12.setDesc("Nov salary");

        e13.setId("12");
        e13.setName("Flight Ticket Spending");
        e13.setMoney(500);
        e13.setAccount("ChaseBank Debit Card");
        e13.setCreatetime("2016-10-30");
        e13.setDesc("Fly to LA");

        e14.setId("13");
        e14.setName("Salary Income");
        e14.setMoney(3000);
        e14.setAccount("ChaseBank Saving Account");
        e14.setCreatetime("2016-10-30");
        e14.setDesc("December Salary");


        expenseService.save(e1);
        expenseService.save(e2);
        expenseService.save(e3);
        expenseService.save(e4);
        expenseService.save(e5);
        expenseService.save(e6);
        expenseService.save(e7);
        expenseService.save(e8);
        expenseService.save(e9);
        expenseService.save(e10);
        expenseService.save(e11);
        expenseService.save(e12);
        expenseService.save(e13);
        expenseService.save(e14);
    }
}
