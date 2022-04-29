package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activities;
import edu.tcu.cs.expensetracker.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class ActivityService {


    private ActivityDao activityDao;

    private IdWorker idWorker;

    public ActivityService(ActivityDao activityDao, IdWorker idWorker) {
        this.activityDao = activityDao;
        this.idWorker = idWorker;
    }





    public List<Activities> findAll() {
        return activityDao.findAll();
    }

    public Activities findById(String activityId) {return activityDao.findById(activityId).get();}

    public List<Activities> findAllByCreationTimeBetween(String startDate, String endDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date1 = formatter.parse(startDate);
        Date date2 = formatter.parse(endDate);
        return activityDao.findAllByCreationTimeBetween(date1, date2);
    }

    public void save(Activities activity) {
        activity.setId(idWorker.nextId() + "");
        activityDao.save(activity);
    }

    public void update(String activityId, Activities activity) {
        activity.setId(activityId);
        activityDao.save(activity);
    }

    public void deleteById(String activityId) {
        activityDao.deleteById(activityId);
    }
}
