package mockito.day2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.core.convert.support.DefaultConversionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
@AllArgsConstructor
@Data
class Product {
    String name;
    Long value;
    String rank;
    Integer seq;
    Boolean isTotal = false;
}
public class T1012 {
    public static void main(String[] args) {
        Set<Product> set = new HashSet(){{
            add(new Product("鼠标", 36L, null, null, false));
            add(new Product("手机", 998L, null, null, false));
            add(new Product("键盘", 101L, null, null, false));
            add(new Product("鼠标", 66L, null, null, false));
            add(new Product("键盘", 203L, null, null, false));
            add(new Product("键盘", 2203L, null, null, false));

            add(new Product("鼠标", 102L, null, null, true));
            add(new Product("手机", 998L, null, null, true));
            add(new Product("键盘", 2507L, null, null, true));

            add(new Product("aa", 0L, null, null, true));
            add(new Product("aa", 0L, null, null, false));
            add(new Product("bb", 0L, null, null, true));
            add(new Product("bb", 0L, null, null, false));
        }};
        List<Product> list = new ArrayList<>(set);
        ////////
        List<String> sortedNames = list.stream().filter(Product::getIsTotal)
                .sorted(Comparator.comparing(Product::getValue, Comparator.reverseOrder()))
                .map(Product::getName)
                .distinct()
                .collect(Collectors.toList());

        List<Product> res = new ArrayList<>();
        for (String name : sortedNames) {
            Long rank = sortedNames.indexOf(name) + 1L;
            List<Product> collect = list.stream().filter(e -> Objects.equals(e.getName(), name))
                    .sorted(
                            Comparator.comparing((Product e) -> e.getIsTotal() ? 1 : 0, Comparator.reverseOrder())
                                    .thenComparing(Product::getValue, Comparator.reverseOrder()))
                    .collect(Collectors.toList());
            collect.forEach(e->e.setRank(String.valueOf(rank)));
            res.addAll(collect);
        }
        int req = 1;
        for (Product p : res) {
            p.setSeq(req++);
        }

        return;
    }


}
