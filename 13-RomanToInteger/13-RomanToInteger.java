// Last updated: 10/09/2025, 15:09:02
class Solution {
    public int romanToInt(String s) {
        int result = 0;

        int[] val = new int[26];
        val['I' - 'A'] = 1;
        val['V' - 'A'] = 5;
        val['X' - 'A'] = 10;
        val['L' - 'A'] = 50;
        val['C' - 'A'] = 100;
        val['D' - 'A'] = 500;
        val['M' - 'A'] = 1000;

        for (int i = 0; i < s.length(); i++) {
            int current = val[s.charAt(i) - 'A'];
            int next = (i + 1 < s.length()) ? val[s.charAt(i + 1) - 'A'] : 0;

            // If the current value is less than the next value, subtract it; otherwise, add it
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}