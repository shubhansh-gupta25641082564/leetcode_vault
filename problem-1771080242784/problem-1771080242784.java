// Last updated: 14/02/2026, 20:14:02
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        char[] arr = new char[26];
4        char c = 'z';
5        for (int i = 0; i < arr.length; i ++) {
6            arr[i] = c;
7            c --;
8        }
9        String ans = "";
10        for (int i = 0; i < words.length; i ++) {
11            int sum = 0;
12            for (int j = 0; j < words[i].length(); j ++) {
13                char ch = words[i].charAt(j);
14                int idx = ch - 'a';
15                sum += weights[idx];
16            }
17            sum = sum % 26;
18            ans += arr[sum];
19        }
20        return ans;
21    }
22}