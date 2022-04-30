package edu.tcu.cs.expensetracker.dataInitializer;

import edu.tcu.cs.expensetracker.dao.UserActivityDao;
import edu.tcu.cs.expensetracker.domain.UserActivity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private UserActivityDao uad;

    public DBDataInitializer(UserActivityDao uad) {
        this.uad = uad;
    }

    @Override
    public void run(String... args) throws Exception {
        UserActivity a1 = new UserActivity();
        a1.setId("1");
        a1.setName("jone");
        a1.setMoney("1000");
        a1.setAccount("BB&T");
        a1.setCreatetime("2020-10-02");
        a1.setDescription("lifestyle");

        UserActivity a2 = new UserActivity();
        a2.setId("2");
        a2.setName("jonny");
        a2.setMoney("1031");
        a2.setAccount("BB&T");
        a2.setCreatetime("2020-9-20");
        a2.setDescription("cycle");

        UserActivity a3 = new UserActivity();
        a3.setId("3");
        a3.setName("jonah");
        a3.setMoney("10");
        a3.setAccount("chase");
        a3.setCreatetime("2021-8-20");
        a3.setDescription("car");

        UserActivity a4 = new UserActivity();
        a4.setId("4");
        a4.setName("joe");
        a4.setMoney("2000");
        a4.setAccount("BB&T");
        a4.setCreatetime("2021-12-20");
        a4.setDescription("motercyle");

        UserActivity a5 = new UserActivity();
        a5.setId("5");
        a5.setName("jane");
        a5.setMoney("5000");
        a5.setAccount("BB&T");
        a5.setCreatetime("20-10-12");
        a5.setDescription("house");

        uad.save(a1);
        uad.save(a2);
        uad.save(a3);
        uad.save(a4);
        uad.save(a5);


    }
}
