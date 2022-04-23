package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
