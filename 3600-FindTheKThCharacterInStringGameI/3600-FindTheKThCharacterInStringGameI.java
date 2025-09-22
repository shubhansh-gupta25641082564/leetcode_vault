// Last updated: 22/09/2025, 16:13:09
class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");
        
        // Keep applying the operation until word is at least k characters long
        while (word.length() < k) {
            int n = word.length();
            // Build the "next" part by shifting each char
            StringBuilder next = new StringBuilder(n);
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                // shift 'a'..'z' cyclically
                next.append(c == 'z' ? 'a' : (char)(c + 1));
            }
            // Append shifted string
            word.append(next);
        }
        
        // Return the k-th character (1-based index)
        return word.charAt(k - 1);
    }
}
