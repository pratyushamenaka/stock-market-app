package com.crypto.currency.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Util class for date and time conversions on server side
 * For now conversions are handled at front end
 */
public class StockMarketUtil {

    public static String convertTime(String inputTime) {
        if(inputTime.isEmpty()) {
            return null;
        }
        return LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HHmm")).format(DateTimeFormatter.ofPattern("hh:mma"));
    }

    public static String convertDate(String inputDate) {
        if(inputDate.isEmpty()) {
            return null;
        }

        DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("dd-MMM-yy");
        LocalDate datetime = LocalDate.parse(inputDate, oldPattern);

        return datetime.format(newPattern);
    }
}
