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

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public Result findAll(){
        List<Activity> all = activityService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success",all);
        return result;
    }

    @GetMapping("/{activityId}")
    public Result findById(@PathVariable Integer activityId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success",activityService.findById(activityId));
    }

    @GetMapping("/{start}/{end}")
    public Result searchByDate(@PathVariable String start, @PathVariable String end) {
        List<Activity> byDate = activityService.searchByDate(start, end);
        return new Result(true, StatusCode.SUCCESS, "Find By Date Success", byDate);
    }

    @PostMapping
    public Result save(@RequestBody Activity newActivity){
        activityService.save(newActivity);
        return new Result(true,StatusCode.SUCCESS,"Save Success");
    }

    @PutMapping("/{activityId}")
    public Result update(@PathVariable int activityId, @RequestBody Activity updatedActivity) {
        activityService.update(activityId, updatedActivity);
        return new Result(true, StatusCode.SUCCESS, "Updated Success");
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable int activityId) {
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
