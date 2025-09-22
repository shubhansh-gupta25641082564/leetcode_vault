// Last updated: 22/09/2025, 12:06:59
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if (n == 1) return true;
        boolean firstCapital = Character.isUpperCase(word.charAt(0));
        boolean secondCapital = Character.isUpperCase(word.charAt(1));

        if (firstCapital && secondCapital) {
            // All remaining must be capitals
            for (int i = 2; i < n; i++) {
                if (!Character.isUpperCase(word.charAt(i))) return false;
            }
        } else if (firstCapital) {
            // All remaining must be lowercase
            for (int i = 2; i < n; i++) {
                if (!Character.isLowerCase(word.charAt(i))) return false;
            }
        } else {
            // First is lowercase, all must be lowercase
            for (int i = 1; i < n; i++) {
                if (!Character.isLowerCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
