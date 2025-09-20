// Last updated: 20/09/2025, 21:57:06
import java.util.*;
public class Router {
    private final int memoryLimit;
    private final Deque<Packet> queue;
    private final Set<Packet> set;
    private final Map<Integer, DestData> destMap;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.set = new HashSet<>();
        this.destMap = new HashMap<>();
    }
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);
        if (set.contains(p)) return false;
        queue.addLast(p);
        set.add(p);
        DestData dd = destMap.get(destination);
        if (dd == null) {
            dd = new DestData();
            destMap.put(destination, dd);
        }
        dd.times.add(timestamp);
        if (queue.size() > memoryLimit) {
            Packet rem = queue.pollFirst();
            if (rem != null) {
                set.remove(rem);
                DestData rdd = destMap.get(rem.destination);
                if (rdd != null) rdd.removed++;
            }
        }
        return true;
    }
    public int[] forwardPacket() {
        Packet p = queue.pollFirst();
        if (p == null) return new int[0];
        set.remove(p);
        DestData dd = destMap.get(p.destination);
        if (dd != null) dd.removed++;
        return new int[]{p.source, p.destination, p.timestamp};
    }
    public int getCount(int destination, int startTime, int endTime) {
        DestData dd = destMap.get(destination);
        if (dd == null) return 0;
        List<Integer> times = dd.times;
        int n = times.size();
        if (n == 0) return 0;
        int l = lowerBound(times, startTime);
        int r = upperBound(times, endTime) - 1;
        int startIdx = Math.max(l, dd.removed);
        if (r < startIdx) return 0;
        return r - startIdx + 1;
    }
    private static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) >= key) r = m; else l = m + 1;
        }
        return l;
    }
    private static int upperBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) > key) r = m; else l = m + 1;
        }
        return l;
    }
    private static class DestData {
        final ArrayList<Integer> times = new ArrayList<>();
        int removed = 0;
    }
    private static class Packet {
        final int source;
        final int destination;
        final int timestamp;
        Packet(int s, int d, int t) { source = s; destination = d; timestamp = t; }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet)o;
            return source == p.source && destination == p.destination && timestamp == p.timestamp;
        }
        public int hashCode() {
            int h = source;
            h = h * 31 + destination;
            h = h * 31 + timestamp;
            return h;
        }
    }
}
