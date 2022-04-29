package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import edu.tcu.cs.expensetracker.domain.Expense;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

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

    public List<Expense> findExpense(Date startDate, Date endDate){
        return expenseDao.findAll();
    }

    public void save(Expense expense){
        expenseDao.save(expense);
    }

    public void update(Integer id, Expense expense){
        expense.setId(id);
        expenseDao.save(expense);
    }

    public void deleteById(Integer id){
        expenseDao.deleteById(id);
    }
}
