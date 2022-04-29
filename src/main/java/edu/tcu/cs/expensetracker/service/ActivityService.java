package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<Activity> searchAll() {
        return activityDao.findAll();
    }

    public Activity searchActivityById(Integer id) {
        return activityDao.findById(id).get();
    }

    public List<Activity> searchActivityByDate(LocalDate startDate, LocalDate endDate) {
        return activityDao.findByCreateTimeBetween(startDate, endDate);
    }

    public void addActivity(Activity activity) {
        activityDao.save(activity);
    }

    public void editActivity(Integer id, Activity activity) {
        activity.setId(id);
        activityDao.save(activity);
    }

    public void deleteActivity(Integer id) {
        activityDao.deleteById(id);
    }

}
