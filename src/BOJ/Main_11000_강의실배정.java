package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11000_강의실배정 {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;

        for (int[] lecture : inputData()) {
            while (!pq.isEmpty() && pq.peek() <= lecture[0]) {
                pq.poll();
            }
            pq.offer(lecture[1]);
            ans = Math.max(pq.size(), ans);
        }

        System.out.println(ans);
    }

    public static int[][] inputData() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        br.close();
        return input;
    }
}