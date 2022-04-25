package edu.tcu.cs.expensetracker.Services;

import edu.tcu.cs.expensetracker.Domain.Activity;
import edu.tcu.cs.expensetracker.Repositories.ActivityDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActivityService {

    private ActivityDao activityDao;

    public ActivityService(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<Activity> findAll(){
        return activityDao.findAll();
    }

    public Activity findbyId(Integer id) {
        return activityDao.findById(id).get();
    }

    public List<Activity> findbyCreatetime(LocalDate start, LocalDate end) {
        List<LocalDate> list = start.datesUntil(end).collect(Collectors.toList());
        List<Activity> entries = activityDao.findAll();
        List<Activity> finalEntries = new ArrayList<>();
        for(int i=0; i < entries.size(); i++){
            if (list.contains(entries.get(i).getCreatetime())){
                finalEntries.add(entries.get(i));
            }
        }
        return finalEntries;
    }

    public void save(Activity activity){
        activityDao.save(activity);
    }

    public void update(Activity activity) {
        activityDao.save(activity);
    }

    public void deletebyId(Integer id) {
        activityDao.deleteById(id);
    }

}
