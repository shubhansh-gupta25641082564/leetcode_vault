// Last updated: 22/09/2025, 16:13:26
class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        java.util.Stack<Integer> st = new java.util.Stack<>();
        int n = pattern.length();
        for (int i = 0; i <= n; i++) {
            st.push(i + 1);
            if (i == n || pattern.charAt(i) == 'I') {
                while (!st.isEmpty()) sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}
