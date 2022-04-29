package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseDao extends JpaRepository<Expense, String> {
}
