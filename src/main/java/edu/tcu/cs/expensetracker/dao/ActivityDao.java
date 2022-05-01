package edu.tcu.cs.expensetracker.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.tcu.cs.expensetracker.domain.Activity;

public interface ActivityDao extends JpaRepository<Activity, Integer>{


}