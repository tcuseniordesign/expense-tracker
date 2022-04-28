package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActivityService {
    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    public Activity findById(Integer activityId) {
        return activityDao.findById(activityId).get();
    }

    public List<Activity> findByCriteria(String start, String end) {
        List<Activity> all = activityDao.findAll();
        List<Activity> sub = new ArrayList<>();
        LocalDate from = LocalDate.parse(start);
        LocalDate to = LocalDate.parse(end);
        for(Activity act : all){
            LocalDate date = LocalDate.parse(act.getCreatetime());
            if(date.compareTo(from) >= 0 && date.compareTo(to) <= 0){
                sub.add(act);
            }
        }
        return sub;
    }

    public void save(Activity activity) {
        activityDao.save(activity);
    }

    public void update(Integer activityId, Activity activity) {
        activity.setId(activityId);
        activityDao.save(activity);
    }

    public void delete(Integer activityId) {
        activityDao.deleteById(activityId);
    }
}
