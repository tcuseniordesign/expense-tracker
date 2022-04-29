package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public Activity findById(Integer id) {
        return activityDao.findById(id).get();
    }

    public List<Activity> findByStartAndEndDate(String startDate, String endDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, dtf);
        LocalDate end = LocalDate.parse(endDate, dtf);
        List<Activity> activities = activityDao.findAll();
        List<Activity> results = new ArrayList<>();
        for(int i = 0; i < activities.size(); i++) {
            LocalDate date = LocalDate.parse(activities.get(i).getCreateTime(), dtf);
            if(date.isBefore(end) && date.isAfter(start)) {
                results.add(activities.get(i));
            }
        }
        return results;
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
}
