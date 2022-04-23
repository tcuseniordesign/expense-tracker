package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ActivityService {

    private ActivityDao activityDao;
    private IdWorker idWorker;

    // Spring will automatically inject an instance of ActivityDao and an instance of IdWorker into this class
    public ActivityService(ActivityDao activityDao, IdWorker idWorker) {
        this.activityDao = activityDao;
        this.idWorker = idWorker;
    }

    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    public Activity findById(String activityId) {
        return activityDao.findById(activityId).get();
    }

    public Activity findBycreateTime(String createTime) {
        return activityDao.findBycreatetime(createTime);
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

}
