package edu.tcu.cs.expensetracker.Service;

import edu.tcu.cs.expensetracker.Dao.ActivityDao;
import edu.tcu.cs.expensetracker.Domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class ActivityService {

    private final ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao){
        this.activityDao = activityDao;
    }

    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    public Activity findById(int activityId) {
        return activityDao.findById(activityId).get();
    }

    public List<Activity> searchByDate(String start, String end) {
        return activityDao.findByDateBetween(start, end);
    }

    public void save(Activity newActivity) {
        activityDao.save(newActivity);
    }

    public void update(int activityId, Activity updatedActivity) {
        updatedActivity.setId(activityId);
        activityDao.save(updatedActivity);
    }

    public void delete(int activityId) {
        activityDao.deleteById(activityId);
    }
}