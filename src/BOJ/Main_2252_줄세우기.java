package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {

    static int N, M;
    static LinkedList<Integer>[] list;
    static int[] edge;

    public static void main(String[] args) throws IOException {

        make();

        System.out.println(check());
    }

    public static String check() {

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (edge[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(' ');
            while(!list[node].isEmpty()) {
                int temp = list[node].poll();
                edge[temp]--;
                if (edge[temp] == 0) {
                    q.add(temp);
                }
            }
        }

        return sb.toString();
    }

    public static void make() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new LinkedList[N + 1];
        edge = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back =Integer.parseInt(st.nextToken());
            list[front].add(back);
            edge[back]++;
        }

        br.close();
    }
}
