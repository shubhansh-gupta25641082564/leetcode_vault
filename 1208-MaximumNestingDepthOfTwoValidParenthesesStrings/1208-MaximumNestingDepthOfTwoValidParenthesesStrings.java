// Last updated: 01/10/2025, 22:23:21
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;
        
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                depth++;
                answer[i] = depth % 2; // assign based on depth parity
            } else {
                answer[i] = depth % 2; // assign before decreasing depth
                depth--;
            }
        }
        
        return answer;
    }
}
