import java.util.function.BiFunction;

public class Test5 {
    public static void main(String[] args) {
        BiFunction<String,String,String> func = (s1, s2) -> s1 + s2;

        String res = method("heqq", "jjjkk", func );



        return;
    }

    static String method(String var1, String var2, BiFunction<String,String,String> func){
        return func.apply(var1, var2);
    }
}


