import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;

public class DateTest {



    @Test
    public void DateTest() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        DateTimeFormatter  formatter = builder.
                appendValue(ChronoField.DAY_OF_MONTH).
                appendLiteral("-").
                appendValue(ChronoField.MONTH_OF_YEAR).
                appendLiteral("-").
                appendValue(ChronoField.YEAR).
                appendLiteral(" time ").
                appendValue(ChronoField.HOUR_OF_AMPM).
                appendLiteral(":").
                appendValue(ChronoField.MINUTE_OF_HOUR).
                appendLiteral(":").appendValue(ChronoField.SECOND_OF_MINUTE).
                appendValue(ChronoField.AMPM_OF_DAY).
                toFormatter();
//        LocalDateTime dateTime  = LocalDateTime.now();
//        String str =  dateTime.format(formatter);
//        System.out.println(str);

        System.out.println(LocalDateTime.now());

    }

}
