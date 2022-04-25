package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public Result findAll(){
        List<Activity> all = activityService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Find All Success", all);
    }

    @GetMapping("/{activityId}")
    public Result findById(@PathVariable Integer activityId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", activityService.findById(activityId));
    }

    @GetMapping("/time")
    public Result findByDate(@RequestParam String start, @RequestParam String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Result(true, StatusCode.SUCCESS, "Find by Time Range Success", activityService.findByDate(LocalDate.parse(start, formatter), LocalDate.parse(end, formatter)));
    }

    @PostMapping
    public Result save(@RequestBody Activity newActivity){
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{activityId}")
    public Result update(@PathVariable Integer activityId, @RequestBody Activity newActivity){
        activityService.update(activityId, newActivity);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable Integer activityId){
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
