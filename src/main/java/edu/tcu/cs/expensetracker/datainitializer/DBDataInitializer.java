package edu.tcu.cs.expensetracker.datainitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBDataInitializer implements CommandLineRunner {

    public ActivityDao dao;
    public DBDataInitializer(ActivityDao dao) {
        this.dao = dao;
    }
    //     public Activity(Integer id, String name, Double money, String account, LocalDate createTime, String description) {
    @Override
    public void run(String ...args) throws Exception {
        LocalDate date1 = LocalDate.of(2022, 3, 24);
        Activity activity1 = createActivity("John Doe", 542.99, "Savings", date1, "Bought new iPhone");

        LocalDate date2 = LocalDate.of(2022, 4, 18);
        Activity activity2 = createActivity("John Doe", 24.53, "Checking", date2, "Lunch with friends");

        LocalDate date3 = LocalDate.of(2022, 5, 9);
        Activity activity3 = createActivity("John Doe", 250.00, "Savings", date3, "Bought new headphones");

        LocalDate date4 = LocalDate.of(2022, 6, 1);
        Activity activity4 = createActivity("John Doe", 2.75, "Checking", date4, "Coffee in the morning");


        dao.save(activity1);
        dao.save(activity2);
        dao.save(activity3);
        dao.save(activity4);


    }
    public Activity createActivity(String name, Double money, String acc, LocalDate date, String desc) {
        return new Activity(name, money, acc, date, desc);
    }

}