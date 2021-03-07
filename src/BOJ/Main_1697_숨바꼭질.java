package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

    static int subin, sister;
    static int time = 0;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        if (subin < sister) {
            visit = new boolean[sister + 2];
            visit[subin] = true;
            q.add(subin);
            bfs();
        }
        else time = subin - sister;

        System.out.println(time);
        br.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println(time + " : " + q.toString());
            for (int s = 0; s < size; ++s) {
                int temp = q.poll();
                if (temp == sister) return;
                if (temp * 2 <= sister + 1 && !visit[temp * 2]) {
                    visit[temp * 2] = true;
                    q.add(temp * 2);
                }
                if (temp + 1 <= sister && !visit[temp + 1]) {
                    visit[temp + 1] = true;
                    q.add(temp + 1);
                }
                if (temp - 1 >= 0 && !visit[temp - 1]) {
                    visit[temp - 1] = true;
                    q.add(temp - 1);
                }
            }
            time++;
        }
    }
}
