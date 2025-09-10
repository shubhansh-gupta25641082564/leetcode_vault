// Last updated: 10/09/2025, 15:08:20
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map from a signature key to all strings matching that anagram class
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Build a count-based signature: 26 counts separated by '#'
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                counts[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int cnt : counts) {
                keyBuilder.append(cnt).append('#');
            }
            String key = keyBuilder.toString();
            
            // Group under this key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        // Collect all groups
        return new ArrayList<>(map.values());
    }
}