package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.Activity;
import edu.tcu.cs.expensetracker.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ActivityController {
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activity")
    public Result findAll(){
        List<Activity> all = activityService.findAll();
        Result result = new Result(true, 200, "success findall", all);
        return result;
    }
    @GetMapping("/activity/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true, 200, "success findbyid", activityService.findById(id));
    }
    @PostMapping("/activity")
    public Result save(@RequestBody Activity newUserActivity){
        activityService.save(newUserActivity);
        return new Result(true, 200, "success save");
    }
    @PutMapping("/activity/{id}")
    public Result update(@PathVariable String id, @RequestBody Activity updatedUserActivity){
        activityService.update(id, updatedUserActivity);
        return new Result(true, 200, "success save");
    }
    @DeleteMapping("/activity/{id}")
    public Result delete(@PathVariable String id){
        activityService.delete(id);
        return new Result(true, 200, "success delete");
    }

}
