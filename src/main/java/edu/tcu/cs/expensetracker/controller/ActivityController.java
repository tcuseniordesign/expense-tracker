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
        Result result = new Result(true, StatusCode.SUCCESS, "Find all activities success", all);
        return result;
    }

    @GetMapping("/{activityId}")
    public Result findById(@PathVariable Integer activityId) {
        return new Result(true, StatusCode.SUCCESS, "Find activity by id success", activityService.findById(activityId));
    }

    @GetMapping("/{start}/{end}")
    public Result findByCriteria(@PathVariable String start,@PathVariable String end) {
        return new Result(true, StatusCode.SUCCESS, "Find activities by criteria success", activityService.findByCriteria(start, end));
    }

    @PostMapping
    public Result save(@RequestBody Activity activity) {
        activityService.save(activity);
        return new Result(true, StatusCode.SUCCESS, "Save activity success");
    }

    @PutMapping("/{activityId}")
    public Result update(@PathVariable Integer activityId, @RequestBody Activity activity) {
        activityService.update(activityId, activity);
        return new Result(true, StatusCode.SUCCESS, "Update activity success");
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable Integer activityId) {
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete user success");
    }
}
