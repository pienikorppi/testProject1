package com.project.vacationCalculator.controller;

import com.project.vacationCalculator.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/calculate")
public class VacationController {
    
    @Autowired
    private VacationService vacationService;
    
    @GetMapping
    public double calculate(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        
        LocalDate start = startDate != null ? LocalDate.parse(startDate) : null;
        LocalDate end = endDate != null ? LocalDate.parse(endDate) : null;
        
        return vacationService.calculateVacationPay(averageSalary, vacationDays, start, end);
        }
}

