package com.project.vacationCalculator.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequest {
    
    @Getter
    @Setter
    private double averageSalary;
    
    @Getter
    @Setter
    private int vacationDays;
    
    @Getter
    @Setter
    private LocalDate startDate;
    
    @Getter
    @Setter
    private LocalDate endDate;
    
    public VacationRequest(double averageSalary, int vacationDays, LocalDate startDate, LocalDate endDate){
        this.averageSalary = averageSalary;
        this.vacationDays = vacationDays;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
}
