package edu.tcu.cs.expensetracker.Dao;
import edu.tcu.cs.expensetracker.Domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ActivityDao extends JpaRepository<Activity, Integer> {

    List<Activity>findAllByCreateTimeBetween(LocalDate startDate, LocalDate endDate);
}