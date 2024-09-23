package com.project.vacationCalculator.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

@Service
public class VacationService {
    
    public double calculateVacationPay(double averageSalary, int vacationDays, LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            vacationDays = calculateNetVacationDays(startDate, endDate);
        }
        
        // Рассчитываем отпускные
        return (averageSalary / 21.75 * vacationDays); // 21.75 - среднее количество рабочих дней в месяце
    }
    
    private int calculateNetVacationDays(LocalDate start, LocalDate end) {
        
        int totalDays = (int) ChronoUnit.DAYS.between(start, end) + 1;
        
        Set<LocalDate> weekends = new HashSet<>();
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
                weekends.add(date);
            }
        }
        
        return totalDays - weekends.size();
    }
}
