package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Loc[] locs = new Loc[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            locs[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(locs);

        for (Loc loc : locs) {
            sb.append(loc.x).append(' ').append(loc.y).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static class Loc implements Comparable<Loc> {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Loc o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
