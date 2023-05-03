package controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
