package com.example.vacationpaycalculator;

import com.example.vacationpaycalculator.controller.VacationPayController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class VacationPayCalculatorApplicationTests {

    @Autowired
    private VacationPayController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void calculateVacationPay_ReturnsCorrectAnswer() {
        Integer vacationPay = controller.calculateVacationPay(
                100000,
                LocalDate.of(2023, Month.MAY, 16),
                LocalDate.of(2023, Month.JUNE, 16)
        );
        assert 81911 == vacationPay;
    }

    @Test
    void calculateVacationPay_ReturnsCorrectAnswer_WithHolidays() {
        Integer vacationPay = controller.calculateVacationPay(
                100000,
                LocalDate.of(2023, Month.DECEMBER, 15),
                LocalDate.of(2024, Month.JANUARY, 15)
        );
        assert 71672 == vacationPay;
    }
}
