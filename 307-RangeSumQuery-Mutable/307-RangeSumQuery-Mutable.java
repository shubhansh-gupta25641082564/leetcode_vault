// Last updated: 21/09/2025, 18:44:34
class NumArray {
    private int[] tree; // segment tree
    private int n;      // original array size

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];

        // initialize leaves
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }

        // build the tree
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }
    
    public void update(int index, int val) {
        int pos = index + n;
        tree[pos] = val;

        while (pos > 1) {
            pos /= 2;
            tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
        }
    }
    
    public int sumRange(int left, int right) {
        int l = left + n, r = right + n;
        int sum = 0;

        while (l <= r) {
            if ((l % 2) == 1) sum += tree[l++]; // right child
            if ((r % 2) == 0) sum += tree[r--]; // left child
            l /= 2;
            r /= 2;
        }

        return sum;
    }
}
