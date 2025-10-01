// Last updated: 01/10/2025, 22:23:35
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Deque;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> index = new LinkedList<>();
        int n = deck.length;
        for (int i = 0; i < n; i++) index.add(i);
        int[] res = new int[n];
        for (int card : deck) {
            res[index.pollFirst()] = card;
            if (!index.isEmpty()) index.addLast(index.pollFirst());
        }
        return res;
    }
}
