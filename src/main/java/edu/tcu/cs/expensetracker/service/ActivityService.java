package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ActivityService {
    private ActivityDao dao;
    public ActivityService(ActivityDao artifactDao) {
        this.artifactDao = artifactDao;
    }
    /*
     * Service passes the id of an Activity instance to DAO
     */
    public void deleteActivity(int id) {
        dao.deleteById(activityId);
    }

    /*
     * Service passes the Activity object
     */
    public void update(String activityId, Activity updatedActivity) {
        updatedActivity.setId(activityId);
        activityDao.save(updatedActivity);
    }

    /*
     * Service
     */
    public void addActivity(Activity act) {
        dao.addActivity(act);
    }

    public List<Activity> select(String startDate, String endDate) {
        return dao.select(startDate, endDate);
    }

    public List<Activity> selectAll() {
        return dao.selectAll();
    }
}
