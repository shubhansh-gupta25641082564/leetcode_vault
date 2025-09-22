// Last updated: 22/09/2025, 16:13:38
import java.util.*;

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("");
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode(folder));
                curr = curr.children.get(folder);
            }
        }
        
        Map<String, List<TrieNode>> map = new HashMap<>();
        serialize(root, map);
        
        for (List<TrieNode> nodes : map.values()) {
            if (nodes.size() > 1) {
                for (TrieNode node : nodes) {
                    node.deleted = true;
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }
    
    private String serialize(TrieNode node, Map<String, List<TrieNode>> map) {
        if (node.children.isEmpty()) return "";
        List<String> list = new ArrayList<>();
        for (TrieNode child : node.children.values()) {
            list.add(child.name + "(" + serialize(child, map) + ")");
        }
        Collections.sort(list);
        String key = String.join("", list);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(node);
        return key;
    }
    
    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        if (node.deleted) return;
        if (!node.name.equals("")) path.add(node.name);
        if (!path.isEmpty()) result.add(new ArrayList<>(path));
        for (TrieNode child : node.children.values()) {
            collectPaths(child, path, result);
        }
        if (!node.name.equals("")) path.remove(path.size() - 1);
    }
    
    class TrieNode {
        String name;
        Map<String, TrieNode> children = new HashMap<>();
        boolean deleted = false;
        TrieNode(String name) { this.name = name; }
    }
}
