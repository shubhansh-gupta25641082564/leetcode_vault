// Last updated: 01/01/2026, 18:31:10
class Solution {
    private long[] t;
    private int[] arr;
    public long maximumScore(int[] nums) {
        int n = nums.length;
        arr = nums;
        t = new long[4*n];
        build(1, 0, n-1);
        long pS = 0;
        long bS = Long.MIN_VALUE;
        for(int i = 0; i < n-1; i ++) {
            pS += nums[i];
            long minr = query(1, 0, n - 1, i + 1, n - 1);
            long score = pS - minr;
            if(score > bS) {
                bS = score;
            }
        }
        return bS;
    }

    public void build(int node, int left, int right) {
        if(left == right) {
            t[node] = arr[left];
            return;
        }
        int mid = left + (right - left)/2;
        build(node*2, left, mid);
        build(node*2+1, mid+1, right);
        t[node] = Math.min(t[node*2], t[node*2+1]);
    }

    public long query(int node, int left, int right, int ql, int qr) {
        if(ql <= left && right <= qr) {
            return t[node];
        }
        int mid = left+(right - left)/2;
        long ans = Long.MAX_VALUE;
        if(ql<=mid) {
            ans = Math.min(ans, query(node*2, left, mid, ql, qr));
        }
        if(qr>mid) {
            ans = Math.min(ans, query(node*2+1, mid +1, right, ql, qr));
        }
        return ans;
    }
}