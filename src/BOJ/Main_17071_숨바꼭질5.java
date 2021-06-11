package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17071_숨바꼭질5 {

    static int subin, sister;
    static boolean[] visited1 = new boolean[500001];
    static boolean[] visited2 = new boolean[500001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        System.out.println(findSister());

        br.close();
    }

    public static int findSister() {

        if (subin == sister) {
            return 0;
        }

        int step = 1;       // 동생 걸음거리
        int time = 1;   // 시간
        Queue<Integer> q = new LinkedList<>();
        q.add(subin);
        visited2[subin] = true;

        while(!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {
                int loc = q.poll();
                for (int i = 0; i < 3; i++) {
                    int next = move(loc, i);
                    if (next >= 0 && next <= 500000) {
                        if (time % 2 == 1) {
                            if (!visited1[next]) {
                                visited1[next] = true;
                                q.add(next);
                            }
                        } else {
                            if (!visited2[next]) {
                                visited2[next] = true;
                                q.add(next);
                            }
                        }
                    }
                }
            }

            // 동생 이동 시키기
            sister += step++;
            if (sister > 500000) {
                return -1;
            }

            if (time % 2 == 1 && visited1[sister]) {
                return time;
            } else if (time % 2 == 0 && visited2[sister]) {
                return time;
            }

            time++;
        }

        return -1;
    }

    public static int move(int num, int type) {

        switch (type) {
            case 0:
                num++;
                break;
            case 1:
                num--;
                break;
            case 2:
                num *= 2;
                break;
        }

        return num;
    }
}
