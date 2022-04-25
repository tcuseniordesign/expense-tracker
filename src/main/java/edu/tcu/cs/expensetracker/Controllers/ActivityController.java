package edu.tcu.cs.expensetracker.Controllers;

import edu.tcu.cs.expensetracker.Domain.Activity;
import edu.tcu.cs.expensetracker.Domain.Result;
import edu.tcu.cs.expensetracker.Domain.StatusCode;
import edu.tcu.cs.expensetracker.Services.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private ActivityService activityService;
    //Spring will automatically inject an instance of ArtifactDao into this class
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping()
    public Result findAll(){
        List<Activity> all = activityService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }

    @GetMapping("/{activityId}")
    public Result findById(@PathVariable Integer activityId){
        return new Result(true, StatusCode.SUCCESS, "Find One Success", activityService.findbyId(activityId));
    }

    @GetMapping("/{activityStart}/{activityEnd}")
    public Result findById(@PathVariable String activityStart, @PathVariable String activityEnd){
        LocalDate activityStartParsed = LocalDate.parse(activityStart);
        LocalDate activityEndParsed = LocalDate.parse(activityEnd);
        return new Result(true, StatusCode.SUCCESS, "Find Dates Success", activityService.findbyCreatetime(activityStartParsed, activityEndParsed));
    }

    @PostMapping()
    public Result save(@RequestBody Activity newActivity){
        activityService.save(newActivity);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("")
    public Result update(@RequestBody Activity updatedActivity){
        activityService.update(updatedActivity);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{activityId}")
    public Result delete(@PathVariable Integer activityId){
        activityService.deletebyId(activityId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
