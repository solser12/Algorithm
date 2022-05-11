package Programmers;

import java.util.*;

public class 순위검색 {

    public int[] solution(String[] info, String[] query) {

        Node start = init();
        int[] ans = new int[query.length];

        StringTokenizer st;
        for (String s : info) {
            st = new StringTokenizer(s);
            Node now = start;
            for (int i = 0; i < 4; i++) {
                now = now.next.get(st.nextToken());
            }
            now.score.add(Integer.parseInt(st.nextToken()));
        }

        for (Node language : start.next.values()) {
            for (Node position : language.next.values()) {
                for (Node career : position.next.values()) {
                    for (Node soulfood : career.next.values()) {
                        Collections.sort(soulfood.score);
                    }
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < query.length; i++) {

            int sum = 0;
            st = new StringTokenizer(query[i]);
            q.offer(start);

            String type = "";
            for (int j = 0; j < 4; j++) {
                int size = q.size();
                type = st.nextToken();
                for (int s = 0; s < size; s++) {
                    Node now = q.poll();
                    if (type.equals("-")) {
                        for (Node value : now.next.values()) {
                            q.offer(value);
                        }
                    } else {
                        q.offer(now.next.get(type));
                    }
                }
                type = st.nextToken();
            }

            int target = Integer.parseInt(type);
            while (!q.isEmpty()) {
                sum += binarySearch(q.poll().score, target);
            }
            ans[i] = sum;
        }

        return ans;
    }

    public int binarySearch(ArrayList<Integer> arr, int target) {
        int left = -1, right = arr.size();
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (arr.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return arr.size() - right;
    }

    public Node init() {

        Queue<Node> q = new LinkedList<>();

        // language
        Node start = new Node();
        start.next.put("java", new Node());
        start.next.put("cpp", new Node());
        start.next.put("python", new Node());
        for (Node value : start.next.values()) {
            q.offer(value);
        }

        // position
        int size = q.size();
        for (int s = 0; s < size; s++) {
            Node node = q.poll();
            node.next.put("backend", new Node());
            node.next.put("frontend", new Node());
            for (Node value : node.next.values()) {
                q.offer(value);
            }
        }

        // career
        size = q.size();
        for (int s = 0; s < size; s++) {
            Node node = q.poll();
            node.next.put("junior", new Node());
            node.next.put("senior", new Node());
            for (Node value : node.next.values()) {
                q.offer(value);
            }
        }

        // soulfood
        size = q.size();
        for (int s = 0; s < size; s++) {
            Node node = q.poll();
            node.next.put("chicken", new Node());
            node.next.put("pizza", new Node());
        }

        return start;
    }

    public class Node {
        HashMap<String, Node> next;
        ArrayList<Integer> score;

        public Node() {
            this.next = new HashMap<>();
            this.score = new ArrayList<>();
        }
    }
}
