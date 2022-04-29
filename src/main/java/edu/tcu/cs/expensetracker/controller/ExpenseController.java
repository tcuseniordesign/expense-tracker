package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Expense;
import edu.tcu.cs.expensetracker.domain.Result;
import edu.tcu.cs.expensetracker.domain.StatusCode;
import edu.tcu.cs.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public Result findAll(){
        List<Expense> all = expenseService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Success", all);
        return result;
    }
    @GetMapping("/{expenseId}")
    public Result findById(@PathVariable String expenseId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success", expenseService.findById(expenseId));
    }

    @PostMapping
    public Result save(@RequestBody Expense newExpense){
        expenseService.save(newExpense);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }
    @PutMapping("/{expenseId}")
    public Result update(@PathVariable String expenseId, @RequestBody Expense updatedExpense) {
        expenseService.update(expenseId, updatedExpense);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }
    @DeleteMapping("/{expenseId}")
    public Result delete(@PathVariable String expenseId){
        expenseService.delete(expenseId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");

    }
}
