// Last updated: 10/09/2025, 15:08:33
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        // Get the result for (n - 1)
        String prev = countAndSay(n - 1);

        // Generate the current result from the previous
        StringBuilder result = new StringBuilder();
        int count = 0;
        char currentChar = prev.charAt(0);

        for (int i = 0; i < prev.length(); i++) {
            if (prev.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count).append(currentChar);
                currentChar = prev.charAt(i);
                count = 1;
            }
        }

        // Append the last group
        result.append(count).append(currentChar);

        return result.toString();
    }
}