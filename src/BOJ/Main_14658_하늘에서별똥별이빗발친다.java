package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14658_하늘에서별똥별이빗발친다 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Meteor[] meteors = new Meteor[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            meteors[i] = new Meteor(x, y);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < K; i++) {
            int x = meteors[i].x;
            for (int j = 0; j < K; j++) {
                int y = meteors[j].y;
                int cnt = 0;
                for (int k = 0; k < K; k++) {
                    cnt += meteors[k].check(x, y, L);
                }
                ans = Math.min(ans, cnt);
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Meteor {
        int x, y;

        public Meteor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int check(int x, int y, int L) {
            if (this.x >= x && this.x <= x + L && this.y >= y && this.y <= y + L) return 0;
            return 1;
        }
    }
}
