// Last updated: 23/09/2025, 21:42:58
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length), x = 0, y = 0;
        for (int i = 0; i < len; i ++)
        {
            if (i < v1.length)
            {
                x = Integer.parseInt(v1[i]);
            }
            else
            {
                x = 0;
            }
            if (i < v2.length)
            {
                y = Integer.parseInt(v2[i]);
            }
            else
            {
                y = 0;
            }
            if (x < y)
            {
                return -1;
            }
            else if (x > y)
            {
                return 1;
            }
        }
        return 0;
    }
}