// Last updated: 10/09/2025, 15:08:50
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Parenthesis(n, 0, 0, "", list);
        return list;
    }
    public static void Parenthesis(int n, int closed, int open, String ans, List<String> list)
    {
        if (open == n && closed == n)
        {
            list.add(ans);
            return;
        }
        if (open > n || closed > open)
        {
            return;
        }
        Parenthesis(n, closed, open+1, ans+"(", list);
        Parenthesis(n, closed+1, open, ans+")", list);
    }
}