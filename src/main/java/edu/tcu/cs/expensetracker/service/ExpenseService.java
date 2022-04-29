package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.domain.Expense;
import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExpenseService {

    private ExpenseDao expenseDao;

    // Spring will automatically inject an instance of ExpenseDao 

    public ExpenseService(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public List<Expense> findAll(){ return expenseDao.findAll(); }

    public Expense findById(String expenseId) { return expenseDao.findById(expenseId).get(); }

    public List<Expense> findBetweenDates(LocalDate startDate, LocalDate endDate) {
        List <LocalDate> dateList = startDate.datesUntil(endDate).collect(Collectors.toList());
        List <Expense> startDates = expenseDao.findAll();
        List <Expense> endDates = new ArrayList<>();
        
        for (int i = 0; i < startDates.size(); i++) {
            if (dateList.contains(LocalDate.parse(startDates.get(i).getCreateTime()))) {
                endDates.add(startDates.get(i));
            }
        }
        return endDates;
    }

    public void save(Expense newExpense) {
        expenseDao.save(newExpense);
    }

    public void update(String expenseId, Expense updatedExpense) {
        updatedExpense.setId(expenseId);
        expenseDao.save(updatedExpense);
    }

    public void delete(String expenseId) {
        expenseDao.deleteById(expenseId);
    }
}
