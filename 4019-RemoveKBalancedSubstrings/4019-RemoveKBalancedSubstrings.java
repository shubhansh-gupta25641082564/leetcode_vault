// Last updated: 22/10/2025, 19:22:31
class Solution {
    public String removeSubstring(String s, int k) {
        int n = s.length();
        java.util.ArrayList<int[]> st = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && st.get(st.size() - 1)[0] == c) {
                st.get(st.size() - 1)[1]++;
            } else {
                st.add(new int[]{c, 1});
            }
            while (st.size() >= 2) {
                int[] last = st.get(st.size() - 1);
                int[] prev = st.get(st.size() - 2);
                if (last[0] == ')' && prev[0] == '(') {
                    int removeBlocks = Math.min(prev[1] / k, last[1] / k);
                    if (removeBlocks == 0) break;
                    prev[1] -= removeBlocks * k;
                    last[1] -= removeBlocks * k;
                    if (last[1] == 0) {
                        st.remove(st.size() - 1);
                    }
                    if (prev[1] == 0) {
                        st.remove(st.size() - 1);
                    }
                    if (st.size() >= 2) {
                        int[] a = st.get(st.size() - 1);
                        int[] b = st.get(st.size() - 2);
                        if (a[0] == b[0]) {
                            b[1] += a[1];
                            st.remove(st.size() - 1);
                        }
                    }
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] node : st) {
            for (int cnt = 0; cnt < node[1]; cnt++) sb.append((char) node[0]);
        }
        return sb.toString();
    }
}
