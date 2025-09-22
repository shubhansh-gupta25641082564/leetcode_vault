// Last updated: 22/09/2025, 16:13:02
class Solution {
    private int n;
    private int[] tree;
    private int[] baskets;
    
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        this.n = baskets.length;
        this.baskets = baskets;
        this.tree = new int[4 * n];
        build(1, 0, n - 1);
        
        int unplaced = 0;
        for (int f : fruits) {
            if (tree[1] < f) {
                // no basket can hold this fruit
                unplaced++;
            } else {
                // find the leftmost basket index with capacity >= f
                int idx = query(1, 0, n - 1, f);
                // mark that basket as used
                update(1, 0, n - 1, idx, 0);
            }
        }
        return unplaced;
    }
    
    // build segment tree storing max in each range
    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = baskets[l];
        } else {
            int mid = (l + r) >> 1;
            build(node<<1,     l,     mid);
            build(node<<1 | 1, mid+1, r);
            tree[node] = Math.max(tree[node<<1], tree[node<<1 | 1]);
        }
    }
    
    // update position pos to value val
    private void update(int node, int l, int r, int pos, int val) {
        if (l == r) {
            tree[node] = val;
        } else {
            int mid = (l + r) >> 1;
            if (pos <= mid) update(node<<1,     l,     mid, pos, val);
            else          update(node<<1 | 1, mid+1, r,   pos, val);
            tree[node] = Math.max(tree[node<<1], tree[node<<1 | 1]);
        }
    }
    
    // find the leftmost index in [l..r] whose capacity >= val, or -1 if none
    private int query(int node, int l, int r, int val) {
        if (tree[node] < val) return -1;
        if (l == r) return l;
        int mid = (l + r) >> 1;
        if (tree[node<<1] >= val) {
            return query(node<<1, l, mid, val);
        } else {
            return query(node<<1 | 1, mid+1, r, val);
        }
    }
}
