// Last updated: 18/09/2025, 23:30:38
import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return new ArrayList<>();
        dict.add(beginWord);
        Map<String, List<String>> parents = new HashMap<>();
        for (String w : dict) parents.put(w, new ArrayList<>());
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        dist.put(beginWord, 0);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                int d = dist.get(cur);
                for (String nei : dict) {
                    if (nei.equals(cur)) continue;
                    if (!diffByOne(cur, nei)) continue;
                    if (!dist.containsKey(nei)) {
                        dist.put(nei, d + 1);
                        parents.get(nei).add(cur);
                        if (nei.equals(endWord)) found = true;
                        q.add(nei);
                    } else if (dist.get(nei) == d + 1) {
                        parents.get(nei).add(cur);
                    }
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!dist.containsKey(endWord)) return res;
        LinkedList<String> path = new LinkedList<>();
        dfsBuild(endWord, beginWord, parents, path, res);
        return res;
    }

    private void dfsBuild(String word, String beginWord, Map<String, List<String>> parents,
                          LinkedList<String> path, List<List<String>> res) {
        path.addFirst(word);
        if (word.equals(beginWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String p : parents.get(word)) {
                dfsBuild(p, beginWord, parents, path, res);
            }
        }
        path.removeFirst();
    }

    private boolean diffByOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++diff > 1) return false;
        }
        return diff == 1;
    }
}
