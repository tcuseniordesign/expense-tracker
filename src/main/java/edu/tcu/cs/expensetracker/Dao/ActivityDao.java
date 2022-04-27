package edu.tcu.cs.expensetracker.Dao;

import edu.tcu.cs.expensetracker.Domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List <Activity> findByDateBetween(String start, String end);

}
