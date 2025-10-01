// Last updated: 01/10/2025, 22:23:22
class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26]; // store last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] inStack = new boolean[26]; // track characters already in the stack
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStack[c - 'a']) continue; // skip if already in stack
            
            while (!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }
            
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()); // reverse stack to get correct order
        }
        return sb.toString();
    }
}
