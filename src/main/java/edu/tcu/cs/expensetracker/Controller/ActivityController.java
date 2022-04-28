package edu.tcu.cs.expensetracker.Controller;

import edu.tcu.cs.expensetracker.Domain.Activity;
import edu.tcu.cs.expensetracker.Domain.Result;
import edu.tcu.cs.expensetracker.Domain.StatusCode;
import edu.tcu.cs.expensetracker.Service.ActivityService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/activity")

public class ActivityController {

    private final ActivityService activityService;


    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;

    }

    @GetMapping
    public Result searchAll() {
        List<Activity> all = activityService.searchAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Search All Success", all);
        return result;
    }

    @GetMapping("/{activityId}")
    public Result searchById(@PathVariable int activityId) {
        return new Result(true, StatusCode.SUCCESS, "Search By Id Success",
                activityService.searchById(activityId));
    }

    @GetMapping("/{start}/{end}")
    public Result searchByCriteria(@PathVariable String start, @PathVariable String end) {
        List<Activity> criteria = activityService.searchByCriteria(start, end);
        return new Result(true, StatusCode.SUCCESS, "Search By Criteria Success", criteria);
    }

    @PostMapping
    public Result save(@RequestBody Activity newActivity) {
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save Success");

    }

    @PutMapping("/{activityId}")
    public Result update(@PathVariable int activityId, @RequestBody Activity updatedActivity) {
        activityService.update(activityId, updatedActivity);
        Activity a = activityService.searchById(activityId);
        return new Result(true, StatusCode.SUCCESS, "Updated Success", a);
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable int activityId) {
        Activity a = activityService.searchById(activityId);
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success", a);
    }

}
