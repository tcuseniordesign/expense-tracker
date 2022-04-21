package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public Result findAll(){
        List<Activity> all = activityService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success!", all);
        return result;
    }
    @GetMapping("/activities/{activityId}")
    public Result findById(@PathVariable String activityId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success!", activityService.findById(activityId));
    }
    @PostMapping("/activities")
    public Result save(@RequestBody Activity newActivity){
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save Success!");
    }

    @PutMapping("/activities/{activityId}")
    public Result update(@PathVariable String activityId, @RequestBody Activity updatedActivity){
        activityService.update(activityId, updatedActivity);
        return new Result(true, StatusCode.SUCCESS, "Update Success!");
    }

    @DeleteMapping("/activities/{activityId}")
    public Result delete(@PathVariable String activityId){
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success!");
    }
}
