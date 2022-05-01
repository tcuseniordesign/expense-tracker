package edu.tcu.cs.expensetracker.controller;



import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    
    private ActivityService service;

    /*
     * Controller passes the id of activity to ActivityService
     */



    public ActivityController(ActivityService service) {
        this.service = service;
    }



    @DeleteMapping("/{activityId}")
    public Result deleteActivity(@PathVariable int activityId) {
        service.deleteActivity(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Successful");
    }
    
    /*
     * Controller is calling ActivityService's editActivity method and passing act to it.
     */
    @PutMapping("/{activityId}")
    public Result editActivity(@PathVariable int activityId, @RequestBody Activity act) {
        service.editActivity(activityId, act);
        return new Result(true, StatusCode.SUCCESS, "Edit Successful", service.findById(activityId));
    }
    

    /*
     * Controller is invoking the addActivity method of ActivityService
     *
     */
    @PostMapping
    public Result addActivity(@RequestBody Activity act) {
        service.addActivity(act);
        return new Result(true, StatusCode.SUCCESS, "Add Successful", service.findById(act.getId()));
    }

    /*
     * Controller passes start and end date to ActivityService
     * and returns the result to MainView
     */
    @GetMapping("/{activityId}")
    public Result select(@PathVariable int activityId) {
        // List<Activity> acts = service.select(startDate, endDate);
        // for (Activity activity : acts) {
        //     if(startDate.compareTo(activity.getCreatetime()) > 0){
        //         if(endDate.compareTo(activity.getCreatetime()) < 0){
        //             // acts.remove(activity);
        //         } 
        //     }
        // }
        return new Result(true, StatusCode.SUCCESS, "Select Successful", service.findById(activityId));
    }

    /*
     * Controller is calling ActivityService's selectAll method.
     */
    @GetMapping
    public Result selectAll() {
        return new Result(true, StatusCode.SUCCESS, "Select Successful", service.findAll());
    }

    @GetMapping("/{startDate}/{endDate}")
    public Result selectByDate(@PathVariable String startDate, @PathVariable String endDate) {
        List<?> actList = (List<?>) service.findAll();
        List<Activity> retList = new ArrayList<Activity>();
        for (int i = 0; i < actList.size(); i++) {
            Activity a = (Activity) actList.get(i);
            if (startDate.compareTo(a.getCreatetime()) <= 0){
                if (endDate.compareTo(a.getCreatetime()) > 0){
                    retList.add(a);
                }
            }
        }
        return new Result(true, StatusCode.SUCCESS, "Select Successful", retList);
    }
}
