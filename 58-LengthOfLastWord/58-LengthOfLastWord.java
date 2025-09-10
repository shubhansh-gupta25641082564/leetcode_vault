// Last updated: 10/09/2025, 15:08:09
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}