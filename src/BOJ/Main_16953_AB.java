package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16953_AB {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B));
        br.close();
    }

    public static int bfs(int A, int B) {

        HashSet<Long> visited = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        q.offer((long) A);
        visited.add((long) A);

        int cnt = 2;
        while (!q.isEmpty()) {
            int size = q.size();
             for (int s = 0; s < size; s++) {
                 long num = q.poll();

                 long temp = num * 2;
                 if (temp == B) {
                     return cnt;
                 } else if (temp < B && !visited.contains(temp)) {
                     visited.add(temp);
                     q.offer(temp);
                 }

                 temp = num * 10 + 1;
                 if (temp == B) {
                     return cnt;
                 } else if (temp < B && !visited.contains(temp)) {
                     visited.add(temp);
                     q.offer(temp);
                 }
             }

             cnt++;
        }

        return -1;
    }
}
