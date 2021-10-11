package 枚举;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Fruit {

    APPLE(1),

    BANANA(2),

    PEACH(3);

    private final int code;
}
