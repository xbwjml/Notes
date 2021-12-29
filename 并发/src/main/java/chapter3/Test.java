package chapter3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String s = "";
        boolean unique = isUnique(s);
        return;
    }

    private static boolean isUnique(String astr) {
        if( "".equals(astr) ){
            return true;
        }
        Set<String> set = Arrays.stream(astr.split(""))
                                .collect(Collectors.toSet());

        return set.size() == astr.length();
    }
}
