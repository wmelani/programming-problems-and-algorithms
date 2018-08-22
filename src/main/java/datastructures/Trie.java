package datastructures;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class Trie {

    private TrieNode root = new TrieNode(null, false);

    public Trie() {

    }

    public void print() {

        LinkedList<TrieNode> queue = new LinkedList<>();
        queue.push(this.root);
        while (!queue.isEmpty()) {
            var current = queue.poll();
            System.out.format("Value: %s, IsEnd: %s, Children(%s), size: %s\n",
                    current.getValue(),
                    current.getIsEnd(),
                    current
                            .getChildren()
                            .entrySet()
                            .stream()
                            .map(e -> e.getKey() + "")
                            .collect(Collectors.joining(",")),
                    current
                            .getChildren()
                            .size());
            current.getChildren().entrySet().stream().map(Map.Entry::getValue).forEach(queue::offer);
        }
    }

    public boolean add(String value) {
        char[] text = value.toCharArray();
        var current = this.root;
        for (char c : text) {
            if (!current.getChildren().containsKey(c)) {
                var newNode = new TrieNode(c, false);
                current.getChildren().put(c, newNode);
                current = newNode;
            } else {
                current = current.getChildren().get(c);
            }
        }
        current.setIsEnd(true);
        return true;
    }

    public boolean remove(String value) {
        return removeImpl(this.root, value.toCharArray(), 0);
    }

    private boolean removeImpl(TrieNode current, char[] charArray, int index) {
        if (current == null) {
            return false;
        }
        var currentChar = charArray[index];
        if (!current.getChildren().containsKey(currentChar)) {
            return false;
        }
        var next = current.getChildren().get(currentChar);
        if (index + 1 == charArray.length) {
            // next is the final element
            if (next.getChildren().size() > 0) {
                next.setIsEnd(false);
            }
            return true;

        }
        boolean found = this.removeImpl(next, charArray, index + 1);
        if (found) {
            if (next.getChildren().size() <= 1) {
                current.getChildren().remove(currentChar);
            }
            return true;
        }
        return false;
    }

    public boolean exists(String s) {
        var current = this.root;
        var strArray = s.toCharArray();
        for (char c : strArray) {
            if (!current.getChildren().containsKey(c)) {
                return false;
            }
            current = current.getChildren().get(c);
        }
        return current != null;
    }

    @Data
    private static class TrieNode {
        private Map<Character, TrieNode> children;
        private Character value;
        private Boolean isEnd;

        public TrieNode(Character value, boolean isEnd) {
            this.value = value;
            this.isEnd = isEnd;
            this.children = new HashMap<>();

        }
    }
}
