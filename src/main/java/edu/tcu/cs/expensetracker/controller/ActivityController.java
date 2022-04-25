package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import org.springframework.web.bind.annotation.*;
import edu.tcu.cs.expensetracker.service.ActivityService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public Result findAll() {
       Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", activityService.findAll());
       return result;
    }

    @GetMapping("/activities/{activityId}")
    public Result findById(@PathVariable Integer activityId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", activityService.findById(activityId));
    }

    @GetMapping("/activities/date")
    public Result findByDate(@RequestParam String begin, @RequestParam String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Result(true, StatusCode.SUCCESS, "Find Between Dates Success", activityService.findByDate(LocalDate.parse(begin, formatter), LocalDate.parse(end, formatter)));
    }

    @PostMapping("/activities")
    public Result save(@RequestBody Activity newActivity) {
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping ("/activities/{activityId}")
    public Result update(@PathVariable Integer activityId, @RequestBody Activity updatedActivity){
        activityService.update(activityId, updatedActivity);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }


    @DeleteMapping("/activities/{activityId}")
    public Result delete(@PathVariable Integer activityId){
        activityService.delete(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }


}
