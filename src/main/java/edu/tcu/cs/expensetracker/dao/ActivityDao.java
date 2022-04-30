package edu.tcu.cs.expensetracker.dao;

import edu.tcu.cs.expensetracker.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.TypedQuery;
import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, String>{
    @Query("select a from Activity a where a.createtime >= :#{#startDate} AND a.createtime <= :#{#endDate}")
    List<Activity> getAllActivitiesBetweenDates(String startDate, String endDate);
}