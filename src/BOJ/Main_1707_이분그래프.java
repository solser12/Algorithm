package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1707_이분그래프 {

    static int V, E;
    static ArrayList<Integer>[] list;
    static int[] type;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            type = new int[V + 1];

            list = new ArrayList[V + 1];
            for (int i = 1; i < V + 1; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int e1 = Integer.parseInt(st.nextToken());
                int e2 = Integer.parseInt(st.nextToken());
                list[e1].add(e2);
                list[e2].add(e1);
            }

            boolean find = false;
            for (int i = 1; i < V + 1; i++) {
                if (type[i] == 0) {
                    if(check(i)) {
                        find = true;
                        break;
                    }
                }
            }

            if (V != 1 && find) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean check(int start) {

        q.clear();

        type[start] = 1;
        q.add(start);

        int sw = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int node = q.poll();
                for (int i : list[node]) {
                    if (type[i] == type[node]) {
                        return true;
                    }

                    if (type[i] == 0) {
                        type[i] = sw;
                        q.add(i);
                    }
                }
            }

            sw *= -1;
        }

        return false;
    }
}
