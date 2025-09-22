// Last updated: 22/09/2025, 16:13:39
import java.util.*;

class Solution {
    private Map<String, int[]> memo = new HashMap<>();

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        // ensure a < b
        int a = firstPlayer, b = secondPlayer;
        return dfs(n, a, b);
    }

    private int[] dfs(int n, int a, int b) {
        String key = n + "," + a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);
        // If they meet this round
        if (a + b == n + 1) {
            return new int[]{1, 1};
        }
        // generate all possible next positions for (a, b)
        Set<String> nextStates = new HashSet<>();
        List<Integer> winners = new ArrayList<>();
        generateWinners(n, a, b, 1, winners, nextStates);

        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;
        // recurse on each next state
        for (String state : nextStates) {
            String[] parts = state.split(",");
            int na = Integer.parseInt(parts[0]);
            int nb = Integer.parseInt(parts[1]);
            int[] res = dfs((n + 1) / 2, na, nb);
            minRound = Math.min(minRound, res[0] + 1);
            maxRound = Math.max(maxRound, res[1] + 1);
        }
        int[] ans = new int[]{minRound, maxRound};
        memo.put(key, ans);
        return ans;
    }

    private void generateWinners(int n, int a, int b, int k,
                                 List<Integer> winners, Set<String> nextStates) {
        int pairs = n / 2;
        if (k > pairs) {
            // add middle if odd
            List<Integer> w = new ArrayList<>(winners);
            if (n % 2 == 1) {
                w.add((n + 1) / 2);
            }
            Collections.sort(w);
            // find new positions
            int na = -1, nb = -1;
            for (int i = 0; i < w.size(); i++) {
                if (w.get(i) == a) na = i + 1;
                if (w.get(i) == b) nb = i + 1;
            }
            nextStates.add(na + "," + nb);
            return;
        }
        int i = k;
        int j = n - k + 1;
        // meeting case already excluded
        if ((i == a && j == b) || (i == b && j == a)) {
            // they would meet, but handled in dfs
            return;
        }
        // contains a only
        if (i == a || j == a) {
            List<Integer> w = new ArrayList<>(winners);
            w.add(a);
            generateWinners(n, a, b, k + 1, w, nextStates);
        }
        // contains b only
        else if (i == b || j == b) {
            List<Integer> w = new ArrayList<>(winners);
            w.add(b);
            generateWinners(n, a, b, k + 1, w, nextStates);
        }
        // free pair
        else {
            // front wins
            List<Integer> w1 = new ArrayList<>(winners);
            w1.add(i);
            generateWinners(n, a, b, k + 1, w1, nextStates);
            // back wins
            List<Integer> w2 = new ArrayList<>(winners);
            w2.add(j);
            generateWinners(n, a, b, k + 1, w2, nextStates);
        }
    }
}