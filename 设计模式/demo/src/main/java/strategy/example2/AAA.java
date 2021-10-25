package strategy.example2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AAA {

    ADD("+"){
        @Override
        public int exec(int a, int b){
            return a+b;
        }
    },

    MINUS("-"){
        @Override
        public int exec(int a, int b){
            return a-b;
        }
    };

    private String val;

    protected abstract int exec(int a, int b);
}
