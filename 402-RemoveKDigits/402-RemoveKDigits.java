// Last updated: 22/09/2025, 07:49:35
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k >= n) return "0";
        StringBuilder stack = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }
        stack.setLength(stack.length() - k);
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') idx++;
        String ans = stack.substring(idx);
        return ans.isEmpty() ? "0" : ans;
    }
}
