// Last updated: 20/09/2025, 00:31:15
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // order by which concatenation yields larger number
                return (b + a).compareTo(a + b);
            }
        });

        if (arr.length > 0 && arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
