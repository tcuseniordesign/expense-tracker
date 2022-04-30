package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActivityService {
    private ActivityDao activityDao;
    private int n=6;
    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public void update(String id, Activity updatedUserActivity) {
        updatedUserActivity.setId(id);
        activityDao.save(updatedUserActivity);
    }

    public void save(Activity newUserActivity) {

        newUserActivity.setId(n++ + "");
        activityDao.save(newUserActivity);
    }

    public List<Activity> findAll(){
        return activityDao.findAll();
    }

    public Activity findById(String id){
        return activityDao.findById(id).get();
    }

    public void delete(String id) {
        activityDao.deleteById(id);
    }
}
