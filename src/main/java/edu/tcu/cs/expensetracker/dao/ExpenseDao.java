package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ExpenseDao extends JpaRepository<Expense, Integer> {

}
