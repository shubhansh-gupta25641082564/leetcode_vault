// Last updated: 10/09/2025, 15:08:31
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Combinations(candidates, target, ll, 0, ans);
        return ans;
    }
    public static void Combinations(int[] coin, int amount, List<Integer> ll, int idx, List<List<Integer>> ans)
    {
        if (amount == 0)
        {
            ans.add(new ArrayList<>(ll));
            return;
        }
        for (int i = idx; i < coin.length; i ++)
        {
            if (amount >= coin[i])
            {
                ll.add(coin[i]);
                Combinations(coin, amount - coin[i], ll, i, ans);
                ll.remove(ll.size() - 1);
            }
        }
    }
}