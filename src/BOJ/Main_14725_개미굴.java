package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_14725_개미굴 {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            trie.insert(size, st);
        }

        trie.print();

        System.out.println(sb);
        br.close();
    }

    public static class Trie {
        Node root = new Node();

        public void insert(int size, StringTokenizer st) {
            Node node = root;
            for (int i = 0; i < size; i++) {
                String str = st.nextToken();
                node = node.next.computeIfAbsent(str, key -> new Node());
            }
            node.isEnd = true;
        }

        public void print() {
            showNode(0, root);
        }

        public void showNode(int depth, Node node) {
            if (node.isEnd) return;

            for (Map.Entry<String, Node> entry : node.next.entrySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(entry.getKey()).append('\n');
                showNode(depth + 1, entry.getValue());
            }
        }
    }

    public static class Node {
        TreeMap<String, Node> next = new TreeMap<>();
        boolean isEnd = false;
    }
}
