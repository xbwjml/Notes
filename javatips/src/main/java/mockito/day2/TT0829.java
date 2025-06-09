package mockito.day2;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Tar{
    private Date expsDate;
    private Long num;
}

public class TT0829 {
    public static void main(String[] args) {

        List<Tar> tars = Lists.newArrayList(
                //new Tar(new Date(), 1L),
                //new Tar(new Date(), 66L),
                //new Tar(new Date(), null)
        );
        Long max = tars.stream().map(Tar::getNum).filter(Objects::nonNull)
                .reduce(Long::max).orElse(0L);

        //tars.stream().collect(Collectors.averagingDouble(Tar::getNum)).longValue()

        double asDouble = tars.stream().map(Tar::getNum).mapToLong(Long::longValue).average().getAsDouble();
        return;
    }
}
