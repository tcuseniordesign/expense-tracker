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
    private final ActivityDao dao;

    public ActivityService(ActivityDao dao) {
        this.dao = dao;
    }
    public List<Activity> findAll() {
        return dao.findAll();
    }

    public Activity findById(Integer id) {
        return dao.findById(id).get();
    }

    public void save(Activity activity) {
        dao.save(activity);
    }

    public void update(Integer id, Activity activity) {
        activity.setId(id);
        dao.save(activity);
    }

    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    public List<Activity> findByDate(LocalDate startDate, LocalDate endDate){
        return dao.findAllByCreateTimeBetween(startDate, endDate);
    }
}
