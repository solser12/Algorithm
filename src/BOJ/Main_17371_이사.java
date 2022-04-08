package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17371_이사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Loc[] convenience = new Loc[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            convenience[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Loc ans = convenience[0];
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int maxDist = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                maxDist = Math.max(maxDist, calcDist(convenience[i], convenience[j]));
            }

            if (maxDist < dist) {
                dist = maxDist;
                ans = convenience[i];
            }
        }

        System.out.println(ans.x + " " + ans.y);
        br.close();
    }

    public static int calcDist(Loc loc1, Loc loc2) {
        return (int) (Math.pow(loc1.x - loc2.x, 2) + Math.pow(loc1.y - loc2.y, 2));
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
