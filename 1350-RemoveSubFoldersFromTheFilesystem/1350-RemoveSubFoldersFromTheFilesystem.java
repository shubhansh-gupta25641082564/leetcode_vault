// Last updated: 01/10/2025, 22:23:15
import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        
        for (String f : folder) {
            if (result.isEmpty()) {
                result.add(f);
            } else {
                String last = result.get(result.size() - 1);
                if (!f.startsWith(last + "/")) {
                    result.add(f);
                }
            }
        }
        
        return result;
    }
}
