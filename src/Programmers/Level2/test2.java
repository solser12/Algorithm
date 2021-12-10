package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test2 {

    ArrayList<Node> list = new ArrayList<>();

    public int[] solution(String s) {

        boolean[] visited = new boolean[100001];
        String string = s.substring(1, s.length() - 1);
        StringTokenizer st = new StringTokenizer(string, "},");

        Node node = new Node();
        while (st.hasMoreTokens()) {
            String input = st.nextToken();
            if (input.charAt(0) == '{') {
                if (node.arr.size() > 0) {
                    list.add(node);
                }
                node = new Node();
                node.push(Integer.parseInt(input.substring(1)));
            } else {
                node.push(Integer.parseInt(input));
            }
        }
        list.add(node);
        Collections.sort(list);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int num : list.get(i).arr) {
                if (!visited[num]) {
                    ans[i] = num;
                    visited[num] = true;
                    break;
                }
            }
        }

        return ans;
    }

    public static class Node implements Comparable<Node> {
        ArrayList<Integer> arr;

        public Node() {
            this.arr = new ArrayList<>();
        }

        public void push(int i) {
            arr.add(i);
        }

        public int get(int idx) {
            return arr.get(idx);
        }

        @Override
        public int compareTo(Node o) {
            return this.arr.size() - o.arr.size();
        }
    }
}
