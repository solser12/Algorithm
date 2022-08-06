package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1343_폴리오미노 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        Queue<Node> q = new LinkedList<>();
        int xCnt = 0, dotCnt = 0;
        for (char c : arr) {
            if (c == 'X') {
                xCnt++;
                if (dotCnt > 0) {
                    q.offer(new Node(1, dotCnt));
                    dotCnt = 0;
                }
            } else {
                dotCnt++;
                if (xCnt > 0) {
                    q.offer(new Node(0, xCnt));
                    xCnt = 0;
                }
            }
        }

        if (xCnt != 0) {
            q.offer(new Node(0, xCnt));
        } else if (dotCnt != 0) {
            q.offer(new Node(1, dotCnt));
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.type == 0) {
                if (node.count % 2 != 0) {
                    sb.setLength(0);
                    sb.append(-1);
                    break;
                }
                for (int i = 0; i < node.count / 4; i++) {
                    sb.append("AAAA");
                }
                if (node.count % 4 == 2) {
                    sb.append("BB");
                }
            } else {
                for (int i = 0; i < node.count; i++) {
                    sb.append('.');
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Node {
        int type, count;

        public Node(int type, int count) {
            this.type = type;
            this.count = count;
        }
    }
}
