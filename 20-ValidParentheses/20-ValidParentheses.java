// Last updated: 10/09/2025, 15:08:53
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char t = stack.pop();
                if ((c == ')' && t != '(') ||
                    (c == ']' && t != '[') ||
                    (c == '}' && t != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}