// Last updated: 01/10/2025, 22:23:25
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0; // tracks the depth of parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) sb.append(c);
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance > 0) sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
