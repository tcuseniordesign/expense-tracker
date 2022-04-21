package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.SQLException;
import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, String> {
}
