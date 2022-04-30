package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExpenseDao extends JpaRepository<Expense, String> {
    // List<Expense> findByStartDateBetween(Date startDate, Date endDate);
    @Query("select e from Expense e where e.createtime >= :#{#startDate} AND e.createtime <= :#{#endDate}")
    List<Expense> getAllExpensesBetweenDates(String startDate, String endDate);


}
