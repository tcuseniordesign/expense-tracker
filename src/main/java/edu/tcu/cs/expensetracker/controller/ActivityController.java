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
    private final ActivityService service;
    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findById(id));
    }

    @GetMapping("/dates")
    public Result findByDate(@RequestParam String startDate, @RequestParam String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Result(true, StatusCode.SUCCESS, "Find by Date Success", service.findByDate(LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter)));
    }

    @PostMapping
    public Result save(@RequestBody Activity activity){
        service.save(activity);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Activity activity, @PathVariable Integer id){
        service.update(id, activity);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }


}
