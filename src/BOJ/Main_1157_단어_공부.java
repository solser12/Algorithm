package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1157_단어_공부 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] cnt = new int['Z' - 'A' + 1];
        for (int i = 0; i < input.length(); i++) {
            int num = Character.toUpperCase(input.charAt(i)) - 'A';
            cnt[num]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < cnt.length; i++) {
            pq.offer(new Node((char) ('A' + i), cnt[i]));
        }

        Node result = pq.poll();
        if (pq.peek().cnt == result.cnt) {
            System.out.println("?");
        } else {
            System.out.println(result.c);
        }

        br.close();
    }

    public static class Node implements Comparable<Node> {
        char c;
        int cnt;

        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }
}
