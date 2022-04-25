package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.dao.ActivityDao;
import edu.tcu.cs.expensetracker.domain.Activity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActivityServiceTest {
    @Mock
    ActivityDao activityDao;
    @InjectMocks
    ActivityService service;

    List<Activity> list;

//    @BeforeEach
//    void setUp() {
//        Activity a1 = new Activity();
//        a1.setId(1);
//        a1.setName("Dining Spending");
//        a1.setMoney(247.50);
//        a1.setAccount("Chase Bank Credit Card");
//        a1.setCreatetime("2016-03-02");
//        a1.setDescription("Dutches");
//
//        Activity a2 = new Activity();
//        a2.setId(2);
//        a2.setName("Salary Income");
//        a2.setMoney(3000.00);
//        a2.setAccount("Cash");
//        a2.setCreatetime("2016-03-15");
//        a2.setDescription("September Salary");
//        list = new ArrayList<>();
//        list.add(a1);
//        list.add(a2);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void findAll() {
//        when (activityDao.findAll()).thenReturn(list);
//        assertEquals(2, service.findAll().size());
//    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }
}