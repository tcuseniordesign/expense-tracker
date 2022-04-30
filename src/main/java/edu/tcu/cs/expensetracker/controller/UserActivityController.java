package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.UserActivity;
import edu.tcu.cs.expensetracker.service.UserActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserActivityController {
    private UserActivityService userActivityService;

    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @GetMapping("/userActivity")
    public Result findAll(){
        List<UserActivity> all = userActivityService.findAll();
        Result result = new Result(true, 200, "suucess findall", all);
        return result;
    }
    @GetMapping("/userActivity/{id}")
    public Result findById(@PathVariable String id){
        return new Result(true, 200, "success find by id", userActivityService.findById(id));
    }
    @PostMapping("/userActivity")
    public Result save(@RequestBody UserActivity newUserActivity){
        userActivityService.save(newUserActivity);
        return new Result(true, 200, "save success");
    }
    @PutMapping("/userActivity/{id}")
    public Result update(@PathVariable String id, @RequestBody UserActivity updatedUserActivity){
        userActivityService.update(id, updatedUserActivity);
        return new Result(true, 200, "save success");
    }
    @DeleteMapping("/userActivity/{id}")
    public Result delete(@PathVariable String id){
        userActivityService.delete(id);
        return new Result(true, 200, "delete success");
    }

}
