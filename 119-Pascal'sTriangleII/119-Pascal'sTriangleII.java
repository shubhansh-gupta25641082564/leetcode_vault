// Last updated: 18/09/2025, 23:27:31
import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            } else if (t.equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            } else if (t.equals("*")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            } else if (t.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b); // integer division truncates toward zero in Java
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }
}
