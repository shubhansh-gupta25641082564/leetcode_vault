// Last updated: 18/09/2025, 23:29:48
import java.util.*;

public class TaskManager {
    private static class Task {
        final int userId;
        final int taskId;
        final int priority;
        Task(int u, int t, int p) { userId = u; taskId = t; priority = p; }
    }
    private final NavigableSet<Task> set;
    private final Map<Integer, Task> map;
    public TaskManager(List<List<Integer>> tasks) {
        Comparator<Task> cmp = (a, b) -> {
            if (a.priority != b.priority) return Integer.compare(b.priority, a.priority);
            return Integer.compare(b.taskId, a.taskId);
        };
        set = new TreeSet<>(cmp);
        map = new HashMap<>();
        if (tasks != null) {
            for (List<Integer> t : tasks) {
                int u = t.get(0), id = t.get(1), p = t.get(2);
                Task task = new Task(u, id, p);
                set.add(task);
                map.put(id, task);
            }
        }
    }
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        set.add(task);
        map.put(taskId, task);
    }
    public void edit(int taskId, int newPriority) {
        Task old = map.get(taskId);
        if (old == null) return;
        set.remove(old);
        Task updated = new Task(old.userId, old.taskId, newPriority);
        set.add(updated);
        map.put(taskId, updated);
    }
    public void rmv(int taskId) {
        Task old = map.remove(taskId);
        if (old != null) set.remove(old);
    }
    public int execTop() {
        Task top = set.pollFirst();
        if (top == null) return -1;
        map.remove(top.taskId);
        return top.userId;
    }
}
