package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
        LocalDate sDate = LocalDate.parse(startDate, dtf);
        LocalDate eDate = LocalDate.parse(endDate, dtf);
        List<Activity> all = activityDao.findAll();
        List<Activity> filteredResults = new ArrayList<>();
        for(int i = 0; i < all.size(); i++) {
            LocalDate curDate = LocalDate.parse(all.get(i).getCreatTime(), dtf);
            if(curDate.isBefore(eDate) && curDate.isAfter(sDate)) {
                filteredResults.add(all.get(i));
            }
        }
        return filteredResults;
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
