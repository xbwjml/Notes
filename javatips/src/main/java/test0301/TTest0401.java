package test0301;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


public class TTest0401 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        majorityElement(arr);
    }

    public boolean isValid(String s) {

        char[] arr = s.toCharArray();
        Set<Character> leftSet = new HashSet(){{
            add('(');
            add('[');
            add('{');
        }};
        Set<Character> rightSet = new HashSet(){{
            add(')');
            add(']');
            add('}');
        }};

        boolean res = true;
        Stack<Character> stack =new Stack<>();

        for (char c : arr) {
            
        }
        for (int i=0; i<arr.length; i++) {
            if (leftSet.contains(arr[i])) {
                stack.push(c);
            }
            if (rightSet.contains(arr[i])) {
                char left = stack.pop();
                char right = arr[i];
                boolean match = (left == '(' && right == ')')
                        || (left == '[' && right == ']')
                        || (left == '{' && right == '}');
                if (!boolean) {
                    res = false;
                    break;
                }
            }
        }

        return res && res.isEmpty();
    }
}
