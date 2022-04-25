package edu.tcu.cs.expensetracker.controller;

import edu.tcu.cs.expensetracker.domain.Activity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import edu.tcu.cs.expensetracker.service.ActivityService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ActivityControllerTest {
    @Mock
    ActivityService activityService;
    @InjectMocks
    ActivityController activityController;

    List<Activity> list;

    MockMvc mockMvc;

//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(activityController).build();
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
//    void findAll() throws Exception {
//        when(activityService.findAll()).thenReturn(list);
//        mockMvc.perform(MockMvcRequestBuilders.get("/activities").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(jsonPath("$.data", hasSize(2)))
//                .andExpect(jsonPath("$.data[0].id").value(("1"))).andExpect(jsonPath("$.data[0].name").value("Dining Spending"))
//                .andExpect(jsonPath("$.data[1].id").value("2"))
//                .andExpect(jsonPath("$.data[1].name").value("Salary Income"));
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