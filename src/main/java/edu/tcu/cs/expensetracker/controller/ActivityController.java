package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activities;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class ActivityController {

    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public Result findAll() {
        List<Activities> all = activityService.findAll();
        return new Result(true, StatusCode.SUCCESS, "Obtain All Success", all);
    }

    @GetMapping("/activities/{activityId}")
    public Result findById(@PathVariable String activityId)
    {
        return new Result(true, StatusCode.SUCCESS, "Obtain Criteria Success", activityService.findById(activityId));
    }

    @PostMapping("/activities")
    public Result save(@RequestBody Activities activity)
    {
        activityService.save(activity);
        return new Result(true, StatusCode.SUCCESS, "Activity Log Success");
    }

    @PutMapping("/activities/{activityId}")
    public Result update(@PathVariable String activityId, @RequestBody Activities activity)
    {
        activityService.update(activityId, activity);
        return new Result(true, StatusCode.SUCCESS, "Activity Edit Success");
    }

    @DeleteMapping("/activities/{activityId}")
    public Result delete(@PathVariable String activityId)
    {
        activityService.deleteById(activityId);
        return new Result(true, StatusCode.SUCCESS, "Activity Delete Success");
    }

    @GetMapping("/activities/{startDate}/{endDate}")
    public Result findAllByCreationTimeBetween(@PathVariable String startDate, @PathVariable String endDate) throws ParseException {

        return new Result(true, StatusCode.SUCCESS, "Obtain Criteria Success", activityService.findAllByCreationTimeBetween(startDate, endDate));
    }
}
