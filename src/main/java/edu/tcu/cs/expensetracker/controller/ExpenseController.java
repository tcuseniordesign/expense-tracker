package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Expense;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService service;

    public ExpenseController(ExpenseService service){
        this.service = service;
    }

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }

    @GetMapping("/{startDate}/{endDate}")
    public Result findExpense(@PathVariable Date startDate, @PathVariable Date endDate){
        return new Result(true, StatusCode.SUCCESS, "Find Given Start and End Date Success", service.findExpense(startDate, endDate));
    }

    @PostMapping
    public Result save(@RequestBody Expense expense){
        service.save(expense);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Expense expense, @PathVariable Integer id){
        service.update(id, expense);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        service.deleteById(id);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
