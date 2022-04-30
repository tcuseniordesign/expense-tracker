package edu.tcu.cs.expensetracker.dataInitializer;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private ActivityDao activityDao;

    public DBDataInitializer(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity a1 = new Activity();
        a1.setId("2342352341");
        a1.setName("firat");
        a1.setMoney("234243242");
        a1.setAccount("checking");
        a1.setCreatetime("2022-1-1");
        a1.setDescription("activityexpense");

        Activity a2 = new Activity();
        a2.setId("2123452345");
        a2.setName("bingyang");
        a2.setMoney("0");
        a2.setAccount("saving");
        a2.setCreatetime("2022-1-1");
        a2.setDescription("expensive item");

        Activity a3 = new Activity();
        a3.setId("312341234");
        a3.setName("wei");
        a3.setMoney("10353");
        a3.setAccount("checking");
        a3.setCreatetime("2022-1-1");
        a3.setDescription("aaa description of an iteam");

        Activity a4 = new Activity();
        a4.setId("413764256");
        a4.setName("aaaa");
        a4.setMoney("234234");
        a4.setAccount("savings");
        a4.setCreatetime("2022-1-1");
        a4.setDescription("travel expenses");

        Activity a5 = new Activity();
        a5.setId("572143567");
        a5.setName("test");
        a5.setMoney("2346324658");
        a5.setAccount("college fund");
        a5.setCreatetime("2022-1-1");
        a5.setDescription("food expensies");

        activityDao.save(a1);
        activityDao.save(a2);
        activityDao.save(a3);
        activityDao.save(a4);
        activityDao.save(a5);


    }
}
