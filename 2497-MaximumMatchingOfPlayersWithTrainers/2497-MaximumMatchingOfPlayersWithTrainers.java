// Last updated: 22/09/2025, 16:13:24
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        java.util.Arrays.sort(players);
        java.util.Arrays.sort(trainers);
        int i = 0, j = 0, matches = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++; j++;
            } else {
                j++;
            }
        }
        return matches;
    }
}
