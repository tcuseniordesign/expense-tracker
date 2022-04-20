package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public Result findAll() {
        List<Activity> all = activityService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find all activities successful", all);
    }

    @GetMapping("/{activityId}")
    public Result findById(@PathVariable Integer activityId) {
        Activity activity = activityService.findById(activityId);
        return new Result(true, StatusCode.SUCCESS, "Find activity by id successful", activity);
    }

    @GetMapping("/search/{startDate}/{endDate}")
    public Result findByStartAndEndDate(@PathVariable String startDate, @PathVariable String endDate) {
        List<Activity> all = activityService.findByStartAndEndDate(startDate, endDate);
        return new Result(true, StatusCode.SUCCESS, "Find activity by start and end date successful", all);
    }

    @PostMapping
    public Result save(@RequestBody Activity newActivity) {
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save activity successful");
    }

    @PutMapping("/{activityId}")
    public Result update(@PathVariable Integer activityId, @RequestBody Activity updatedActivity) {
        activityService.update(activityId, updatedActivity);
        return new Result(true, StatusCode.SUCCESS, "Update activity successful");
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable Integer activityId) {
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete activity successful");
    }
}
