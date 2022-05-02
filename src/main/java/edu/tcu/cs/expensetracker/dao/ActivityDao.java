package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDao extends JpaRepository<Activity, String> {

    //List<Activity> findByStartDateBetween(String startdate, String enddate);
}