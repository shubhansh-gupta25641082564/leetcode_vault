// Last updated: 10/09/2025, 15:08:57
class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)
        {
            return list;
        }
        Print(digits, "", list);
        return list;
    }   
    public static void Print(String ques, String ans, List<String> list)
    {
        if (ques.length() == 0)
        {
            // System.out.println(ans);
            list.add(ans);
            return;
        }
        char ch = ques.charAt(0);
        String getString = key[ch - '0'];
        for (int i = 0; i < getString.length(); i++)
        {
            Print(ques.substring(1), ans + getString.charAt(i), list);
        }
    }
}