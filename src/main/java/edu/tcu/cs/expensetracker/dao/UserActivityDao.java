package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityDao extends JpaRepository<UserActivity, String> {

}
