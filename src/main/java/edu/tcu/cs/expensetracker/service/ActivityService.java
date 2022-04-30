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

    // Spring will automatically inject an instance of ArtifactDao and an instance of IdWorker into this class
    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    public Activity findById(String activityId) {
        return activityDao.findById(activityId).get();
    }


    public List<Activity> getAllActivitiesBetweenDates(String startDate, String endDate){
        return activityDao.getAllActivitiesBetweenDates(startDate, endDate);
    }

    public void save(Activity newActivity) {
        activityDao.save(newActivity);
    }

    public void update(String activityId, Activity updatedActivity) {
        updatedActivity.setId(activityId);
        activityDao.save(updatedActivity);
    }

    public void delete(String artifactId) {
        activityDao.deleteById(artifactId);
    }
}
