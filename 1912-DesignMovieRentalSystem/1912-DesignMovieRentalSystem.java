// Last updated: 21/09/2025, 16:39:47
import java.util.*;

class MovieRentingSystem {
    private final Map<Long, Integer> priceMap = new HashMap<>();
    private final Map<Integer, TreeSet<long[]>> available = new HashMap<>();
    private final TreeSet<long[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        Comparator<long[]> compAvail = (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        };
        Comparator<long[]> compRented = (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        };
        rented = new TreeSet<>(compRented);
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            long key = (((long) shop) << 32) | (movie & 0xffffffffL);
            priceMap.put(key, price);
            available.computeIfAbsent(movie, x -> new TreeSet<>(compAvail)).add(new long[]{price, shop});
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        TreeSet<long[]> set = available.get(movie);
        if (set == null) return res;
        Iterator<long[]> it = set.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            res.add((int) it.next()[1]);
            cnt++;
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        long key = (((long) shop) << 32) | (movie & 0xffffffffL);
        int price = priceMap.get(key);
        TreeSet<long[]> set = available.get(movie);
        set.remove(new long[]{price, shop});
        rented.add(new long[]{price, shop, movie});
    }
    
    public void drop(int shop, int movie) {
        long key = (((long) shop) << 32) | (movie & 0xffffffffL);
        int price = priceMap.get(key);
        rented.remove(new long[]{price, shop, movie});
        available.get(movie).add(new long[]{price, shop});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<long[]> it = rented.iterator();
        int cnt = 0;
        while (it.hasNext() && cnt < 5) {
            long[] a = it.next();
            res.add(Arrays.asList((int) a[1], (int) a[2]));
            cnt++;
        }
        return res;
    }
}
