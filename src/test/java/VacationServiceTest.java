import com.project.vacationCalculator.service.VacationService;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class VacationServiceTest {
    
    private final VacationService vacationService = new VacationService();
    
    @Test
    public void testCalculateVacationPayWithWeekends(){
        double averageSalary = 60000;
        int vacationDays = 10;
        LocalDate startDate = LocalDate.of(2024, 9, 1); // воскресенье
        LocalDate endDate = LocalDate.of(2024, 9, 14); // суббота
        double expectedPay = 60000 / 21.75 * 10; // 10 рабочих дней
        double calculatedPay = vacationService.calculateVacationPay(averageSalary, vacationDays, startDate, endDate);
        assertEquals(expectedPay, calculatedPay, 0.01);
    }
    
    @Test
    public void testCalculateVacationPayWithoutDates() {
        double averageSalary = 60000;
        int vacationDays = 10;
        double expectedPay = 60000 / 21.75 * 10; // 10 дней
        double calculatedPay = vacationService.calculateVacationPay(averageSalary, vacationDays, null, null);
        assertEquals(expectedPay, calculatedPay, 0.01);
    }
}
