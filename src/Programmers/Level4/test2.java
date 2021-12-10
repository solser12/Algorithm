package Programmers.Level4;

import java.util.HashMap;
import java.util.Map;

public class test2 {

    public int[] solution(String[] words, String[] queries) {

        NormalTrie normalTrie = new NormalTrie();
        ReverseTrie reverseTrie = new ReverseTrie();
        for (String word : words) {
            normalTrie.insert(word);
            reverseTrie.insert(word);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (queries[i].charAt(0) == '?') {
                result[i] = reverseTrie.search(queries[i]);
            } else {
                result[i] = normalTrie.search(queries[i]);
            }
        }

        return result;
    }

    public static class ReverseTrie {
        Node root = new Node();

        public void insert(String s) {
            Node node = this.root;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (!node.count.containsKey(i + 1)) {
                    node.count.put(i + 1, 1);
                } else {
                    node.count.put(i + 1, node.count.get(i + 1) + 1);
                }

                char c = s.charAt(i);
                if (!node.childNode.containsKey(c)) {
                    node.childNode.put(c, new Node());
                }
                node = node.childNode.get(c);
            }
            node.isEnd = true;
        }

        public int search(String s) {
            Node node =this.root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c == '?') {
                    return node.count.getOrDefault(i + 1, 0);
                } else {
                    node = node.childNode.get(c);
                }

                if (node == null) {
                    return 0;
                }
            }

            return 0;
        }
    }

    public static class NormalTrie {
        Node root = new Node();

        public void insert(String s) {
            Node node = this.root;
            for (int i = 0; i < s.length(); i++) {
                if (!node.count.containsKey(s.length() - i)) {
                    node.count.put(s.length() - i, 1);
                } else {
                    node.count.put(s.length() - i, node.count.get(s.length() - i) + 1);
                }

                char c = s.charAt(i);
                if (!node.childNode.containsKey(c)) {
                    node.childNode.put(c, new Node());
                }
                node = node.childNode.get(c);
            }
            node.isEnd = true;
        }

        public int search(String s) {
            Node node =this.root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '?') {
                    return node.count.getOrDefault(s.length() - i, 0);
                } else {
                    node = node.childNode.get(c);
                }

                if (node == null) {
                    return 0;
                }
            }

            return 0;
        }
    }

    public static class Node {
        Map<Character, Node> childNode;
        Map<Integer, Integer> count;
        boolean isEnd;

        public Node() {
            this.childNode = new HashMap<>();
            this.count = new HashMap<>();
            isEnd = false;
        }
    }
}
