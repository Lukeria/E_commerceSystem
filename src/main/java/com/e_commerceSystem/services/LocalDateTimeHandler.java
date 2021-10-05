package com.e_commerceSystem.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class LocalDateTimeHandler {

    public LocalDateTime addWorkDays(LocalDateTime date, int workdays) {

        if (workdays < 1) {
            return date;
        }

        LocalDateTime result = date;
        int addedDays = 0;

        while (addedDays < workdays) {

            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }

        return result;
    }
}
