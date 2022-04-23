package edu.tcu.cs.expensetracker;

import edu.tcu.cs.expensetracker.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ExpenseTracker {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTracker.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
