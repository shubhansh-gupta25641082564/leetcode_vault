// Last updated: 13/09/2025, 13:40:22
class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        java.util.List<Character> vowels = new java.util.ArrayList<>();
        for (char c : arr) {
            if (isVowel(c)) vowels.add(c);
        }
        java.util.Collections.sort(vowels);
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (isVowel(arr[i])) {
                arr[i] = vowels.get(idx++);
            }
        }
        return new String(arr);
    }
    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
