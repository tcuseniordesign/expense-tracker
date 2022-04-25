package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ActivityService {
    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao){
        this.activityDao = activityDao;
    }

    public List<Activity> findAll(){
        return activityDao.findAll();
    }

    public Activity findById(Integer activityId) {
        return activityDao.findById(activityId).get();
    }

    public void save(Activity newActivity) {
        activityDao.save(newActivity);
    }

    public void update(Integer activityId, Activity updatedActivity) {
        updatedActivity.setId(activityId);
        activityDao.save(updatedActivity);
    }

    public void delete(Integer activityId) {
        activityDao.deleteById(activityId);
    }

    public List<Activity> findByDate(LocalDate start, LocalDate end ){
        return activityDao.findAllByCreateTimeBetween(start, end);
    }

}
