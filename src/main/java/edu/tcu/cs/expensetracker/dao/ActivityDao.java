package edu.tcu.cs.expensetracker.dao;


import edu.tcu.cs.expensetracker.domain.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ActivityDao extends JpaRepository<Activities, String> {

List<Activities> findAllByCreationTimeBetween(
        Date startDate,
        Date endDate);
}
