package edu.tcu.cs.expensetracker.Repositories;

import edu.tcu.cs.expensetracker.Domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDao extends JpaRepository<Activity, Integer> {
    Activity findByCreatetime(String start);
}
