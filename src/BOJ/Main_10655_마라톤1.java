package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10655_마라톤1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Loc[] loc = new Loc[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            loc[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        CheckPoint[] checkPoints = new CheckPoint[N - 2];
        checkPoints[0] = new CheckPoint(manhattanDistance(loc[0], loc[1])
                , manhattanDistance(loc[1], loc[2]), manhattanDistance(loc[0], loc[2]));
        int total = checkPoints[0].next, ans = Integer.MAX_VALUE;
        for (int i = 1; i < N - 2; i++) {
            int next = manhattanDistance(loc[i + 1], loc[i + 2]);
            int skip = manhattanDistance(loc[i], loc[i + 2]);
            checkPoints[i] = new CheckPoint(checkPoints[i - 1].next, next, skip);
            total += next;
        }

        for (CheckPoint checkPoint : checkPoints) {
            total -= checkPoint.next;
            total += checkPoint.skip;
            ans = Math.min(ans, total);
            total -= checkPoint.skip;
            total += checkPoint.prev;
        }

        System.out.println(ans);
        br.close();
    }

    public static int manhattanDistance(Loc loc1, Loc loc2) {
        return Math.abs(loc1.x - loc2.x) + Math.abs(loc1.y - loc2.y);
    }

    public static class CheckPoint {
        int prev, next, skip;

        public CheckPoint(int prev, int next, int skip) {
            this.prev = prev;
            this.next = next;
            this.skip = skip;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
