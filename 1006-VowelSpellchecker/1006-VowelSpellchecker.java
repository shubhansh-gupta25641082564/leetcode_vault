// Last updated: 01/10/2025, 22:23:32
import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelError = new HashMap<>();
        
        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            String devowel = devowel(lower);
            vowelError.putIfAbsent(devowel, word);
        }
        
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                res[i] = q;
            } else if (caseInsensitive.containsKey(q.toLowerCase())) {
                res[i] = caseInsensitive.get(q.toLowerCase());
            } else if (vowelError.containsKey(devowel(q.toLowerCase()))) {
                res[i] = vowelError.get(devowel(q.toLowerCase()));
            } else {
                res[i] = "";
            }
        }
        return res;
    }
    
    private String devowel(String word) {
        return word.replaceAll("[aeiou]", "*");
    }
}
