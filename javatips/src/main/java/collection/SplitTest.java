package collection;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SplitTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd YYYY HH:mm:ss");
        String s = format.format(new Date());

        Date date = new Date();
        date.setYear(121);
        date.setMonth(11);
        date.setDate(26);
        String res = format.format(date);

        LocalDate.now().lengthOfYear();
        return;
    }
}
