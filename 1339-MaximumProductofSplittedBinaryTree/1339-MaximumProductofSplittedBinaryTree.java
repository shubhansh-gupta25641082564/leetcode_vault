// Last updated: 13/02/2026, 21:34:42
1class Solution {
2    public int maxProduct(TreeNode root) {
3        final long MOD = 1_000_000_007L;
4        java.util.ArrayList<Long> sums = new java.util.ArrayList<>();
5        long total = computeSubtreeSums(root, sums);
6
7        long best = 0;
8        for (long s : sums) {
9            long prod = s * (total - s);
10            if (prod > best) best = prod;
11        }
12        return (int) (best % MOD);
13    }
14
15    private long computeSubtreeSums(TreeNode root, java.util.ArrayList<Long> sums) {
16        java.util.Deque<TreeNode> st = new java.util.ArrayDeque<>();
17        java.util.Deque<TreeNode> order = new java.util.ArrayDeque<>();
18        st.push(root);
19
20        while (!st.isEmpty()) {
21            TreeNode node = st.pop();
22            order.push(node);
23            if (node.left != null) st.push(node.left);
24            if (node.right != null) st.push(node.right);
25        }
26
27        java.util.IdentityHashMap<TreeNode, Long> map = new java.util.IdentityHashMap<>();
28        while (!order.isEmpty()) {
29            TreeNode node = order.pop();
30            long left = node.left == null ? 0L : map.get(node.left);
31            long right = node.right == null ? 0L : map.get(node.right);
32            long sum = left + right + node.val;
33            map.put(node, sum);
34            sums.add(sum);
35        }
36
37        return map.get(root);
38    }
39}
40