package edu.tcu.cs.expensetracker.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.utils.IdWorker;

@Service
@Transactional
public class ActivityService {
    private ActivityDao dao;
    private IdWorker idWorker;

    


    public ActivityService(ActivityDao dao, IdWorker idWorker) {
        this.dao = dao;
        this.idWorker = idWorker;
    }    
    
    
    /*
     * Service passes the id of an Activity instance to DAO
     */
    public void deleteActivity(int id) {
        dao.deleteById(id);
    }

    /*
     * Service passes the Activity object
     */
    public void editActivity(int activityId, Activity act) {
        act.setId(activityId);
        dao.save(act);
    }

    /*
     * Service
     */
    public void addActivity(Activity act) {
        act.setId((int) idWorker.nextId()); 
        dao.save(act);
    }

    public Object findAll(){
        return dao.findAll();
    }

    public Object findById(int id){
        return dao.findById(id);
    }

    // //TODO
    // public List<Activity> select(String startDate, String endDate) {
    //     return dao.findAll();
    //     // List<Activity> acts = dao.findAll();
    //     // for (Activity activity : acts) {
    //     //     if( startDate.compareTo(activity.getCreatetime()) >0 ){
    //     //         acts.remove(activity);
    //     //     } 
    //     // }
    //     // return acts;
    // }
}
