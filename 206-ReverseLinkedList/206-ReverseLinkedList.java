// Last updated: 21/09/2025, 18:07:54
import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // Memoization to avoid recomputation
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expr, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expr)) return memo.get(expr);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftPart = expr.substring(0, i);
                String rightPart = expr.substring(i + 1);

                List<Integer> leftResults = compute(leftPart, memo);
                List<Integer> rightResults = compute(rightPart, memo);

                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') res.add(left + right);
                        else if (c == '-') res.add(left - right);
                        else if (c == '*') res.add(left * right);
                    }
                }
            }
        }

        // If res is empty, expr is a number
        if (res.isEmpty()) res.add(Integer.parseInt(expr));

        memo.put(expr, res);
        return res;
    }
}
