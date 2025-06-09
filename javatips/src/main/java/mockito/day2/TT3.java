package mockito.day2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TT3 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("20220413", DateTimeFormatter.ofPattern("yyyyMMdd"));
        //localDate = LocalDate.now();

        LocalDate lastQeDate = localDate.withMonth(localDate.getMonth().firstMonthOfQuarter().getValue()).withDayOfMonth(1).minusDays(1);

        LocalDate lastQuarterDate = localDate.minusMonths(3);
        LocalDate last2QeDate = lastQuarterDate.withMonth(lastQuarterDate.getMonth().firstMonthOfQuarter().getValue()).withDayOfMonth(1).minusDays(1);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        String s = lastQeDate.getYear() + "|" + lastQeDate.getMonth().getValue();
        String s2 = last2QeDate.getYear() + "|" + last2QeDate.getMonth().getValue();

        String s3 = last2QeDate.getYear() + "|" + last2QeDate.getMonthValue();

        System.out.println(lastQeDate);
        System.out.println(last2QeDate);
        return;
    }
}
