package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import edu.tcu.cs.expensetracker.domain.Expense;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseService {
    private ExpenseDao expenseDao;

    public ExpenseService(ExpenseDao expenseDao){
        this.expenseDao = expenseDao;
    }

    public List<Expense> findAll() {
        return expenseDao.findAll();
    }

    public List<Expense> getAllExpensesBetweenDates(String startDate, String endDate){
        return expenseDao.getAllExpensesBetweenDates(startDate, endDate);// findByStartDateBetween(startDate, endDate);
    }

    public Expense findById(String id){
        return expenseDao.findById(id).get();
    }

    public void save(Expense expense){
        expenseDao.save(expense);
    }

    public void update(String id, Expense expense){
        expense.setId(id);
        expenseDao.save(expense);
    }

    public void deleteById(String id){
        expenseDao.deleteById(id);
    }
}
