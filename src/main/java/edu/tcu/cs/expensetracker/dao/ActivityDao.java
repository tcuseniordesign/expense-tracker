package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDao extends JpaRepository<Activity, String> {
    Activity findBycreatetime(String createTime);
}
