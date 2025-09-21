// Last updated: 21/09/2025, 18:51:44
import java.util.*;
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
    
    // Build the adjacency list
    List<Set<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new HashSet<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }
    
    // Initialize leaves
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (adj.get(i).size() == 1) leaves.add(i);
    }
    
    int remainingNodes = n;
    while (remainingNodes > 2) {
        remainingNodes -= leaves.size();
        List<Integer> newLeaves = new ArrayList<>();
        
        for (int leaf : leaves) {
            int neighbor = adj.get(leaf).iterator().next();
            adj.get(neighbor).remove(leaf);
            if (adj.get(neighbor).size() == 1) newLeaves.add(neighbor);
        }
        
        leaves = newLeaves;
    }
    
    return leaves;
    }
}