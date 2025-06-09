package mockito.day2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Car{
    private String band;
    private Long weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(band, car.band) && Objects.equals(weight, car.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, weight);
    }
}

public class TTT {
    public static void main(String[] args) {
        List<Car> list = new ArrayList(){{
            add(new Car("aa", 100L));
            add(new Car("aa", 200L));
        }};

        Map<Car, Long> carMap = list.stream().collect(Collectors.toMap(
                e -> e,
                e -> e.getWeight(),
                (e1, e2) -> e1
        ));

        Car x = new Car("aax", 100L);
        boolean b = carMap.containsKey(x);
        return;
    }
}
