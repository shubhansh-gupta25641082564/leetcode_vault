// Last updated: 27/01/2026, 16:21:25
1class Solution {
2    public int getXORSum(int[] arr1, int[] arr2) {
3        int xor1 = Bitwise_XOR(arr1);
4        int xor2 = Bitwise_XOR(arr2);
5        return (xor1 & xor2);
6    }
7    public static int Bitwise_XOR(int[] arr) {
8        int xor = 0;
9        for(int v : arr) {
10            xor ^= v;
11        }
12        return xor;
13    }
14}