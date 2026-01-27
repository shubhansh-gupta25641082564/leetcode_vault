// Last updated: 27/01/2026, 16:20:41
1class Solution {
2    public int xorAllNums(int[] nums1, int[] nums2) {
3        int n = nums1.length;
4        int m = nums2.length;
5        if(n % 2 == 0 & m % 2 == 0){
6            return 0;
7        }
8        int xor1 = Bitwise_XOR(nums1);
9        int xor2 = Bitwise_XOR(nums2);
10        if(n%2==1 & m%2==1)  {
11            return xor1 ^ xor2;
12        } else if(n%2 == 1) {//odd wale array ka even pair hoga inka xor 0
13            return xor2;//isliye yaha se even wala return kra hai kyuki inka 
14        } else {
15            return xor1;
16        }
17    }
18    public static int Bitwise_XOR(int[] arr) {
19        int xor = 0;
20        for(int v : arr) {
21            xor ^= v;
22        }
23        return xor;
24    }
25}