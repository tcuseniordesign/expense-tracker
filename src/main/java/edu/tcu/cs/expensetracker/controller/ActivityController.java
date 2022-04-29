package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) { this.activityService = activityService; }

    @GetMapping
    public Result searchAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", activityService.searchAll());
    }

    @GetMapping("/{id}")
    public Result searchActivityById(@PathVariable Integer id) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", activityService.searchActivityById(id));
    }

    @GetMapping("/inRange")
    public Result searchActivityByDate(@RequestParam String startDate, @RequestParam String endDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        return new Result(true, StatusCode.SUCCESS, "Find By Date Success", activityService.searchActivityByDate(LocalDate.parse(startDate, format), LocalDate.parse(endDate, format)));
    }

    @PostMapping
    public Result addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
        return new Result(true, StatusCode.SUCCESS, "Add Success");
    }

    @PutMapping("/{id}")
    public Result editActivity(@PathVariable Integer id, @RequestBody Activity activity) {
        activityService.editActivity(id, activity);
        return new Result(true, StatusCode.SUCCESS, "Edit Success");
    }

    @DeleteMapping("/{id}")
    public Result deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
