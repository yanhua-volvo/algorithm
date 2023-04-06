package leetbook.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yh_wang
 * @date: 2023-04-06 18:00
 **/
public class ValidBrackets {

    public static void main(String[] args) {
        boolean valid = isValid("");

        System.out.println(valid);
    }

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }

                if (c == ']' && pop != '[') {
                    return false;
                }

                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
