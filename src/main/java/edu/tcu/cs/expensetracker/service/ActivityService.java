package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.utils.IdWorker;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    private ActivityDao activityDao;
    private IdWorker idWorker;


    public ActivityService(ActivityDao activityDao, IdWorker idWorker) {
        this.activityDao = activityDao;
        this.idWorker = idWorker;
    }

    public List<Activity> findAll(){
            return  activityDao.findAll();
    }

    public void save(Activity newActivity) {
        newActivity.setId(idWorker.nextId() + "");
        activityDao.save(newActivity);
    }

    public void update(String activityId, Activity updatedActivity) {
        updatedActivity.setId(activityId);
        activityDao.save(updatedActivity);
    }

    public void delete(String activityId) {
        activityDao.deleteById(activityId);

    }

    public Activity findById(String activityId) {
        return activityDao.findById(activityId).get();
    }

    public List<Activity> findAllBetween(String sdate,String edate) throws ParseException{
         List<Activity> temp = activityDao.findAll();
        List<Activity> ans = new ArrayList<>();
        //YYYY-MM-DD
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
        //Parsing the given String to Date object
        Date Start = formatter.parse(sdate);
        Date End = formatter.parse(edate);
        for(int i = 0 ; i <temp.size();i++ ){
            Activity t = temp.get(i);
            Date check = formatter.parse(t.time);
            Boolean bool1 = check.after(Start);
            Boolean bool2 = check.before(End);
            
            if(bool1 && bool2){
                ans.add(t);
            }
        }
        System.out.println(sdate);
        System.out.println(edate);
        return  ans;
    }
}
