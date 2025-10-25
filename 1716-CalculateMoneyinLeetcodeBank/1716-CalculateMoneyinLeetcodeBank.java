// Last updated: 25/10/2025, 16:37:13
class Solution {
    public int totalMoney(int n) {
        int sum = 0, i = 1, j = 1, monday = j;
        while(i <= n) {
            if (i % 7 == 0) {
                sum += j;
                monday++;
                j = monday;
            }
            else {
                sum += j;
                j ++;
            }
            i ++;
        }
        return sum;
    }
}