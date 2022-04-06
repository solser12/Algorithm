package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2162_선분그룹 {

    public static int N;
    public static int[] parents, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];
        make();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int groupCnt = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Loc loc1 = lines[i].l1;
                Loc loc2 = lines[i].l2;
                Loc loc3 = lines[j].l1;
                Loc loc4 = lines[j].l2;
                int result1 = ccw(loc1, loc2, loc3) * ccw(loc1, loc2, loc4);
                int result2 = ccw(loc3, loc4, loc1) * ccw(loc3, loc4, loc2);

                if (result1 == 0 && result2 == 0) {
                    if (loc1.compareTo(loc2) > 0) {
                        Loc temp = loc1;
                        loc1 = loc2;
                        loc2 = temp;
                    }
                    if (loc3.compareTo(loc4) > 0) {
                        Loc temp = loc3;
                        loc3 = loc4;
                        loc4 = temp;
                    }

                    if (loc1.compareTo(loc4) <= 0 && loc3.compareTo(loc2) <= 0) {
                        if (union(i, j)) {
                            groupCnt--;
                        }
                    }
                } else if (result1 <= 0 && result2 <= 0) {
                    if (union(i, j)) {
                        groupCnt--;
                    }
                }
            }
        }

        int maxCnt = 0;
        for (int i : count) {
            maxCnt = Math.max(i, maxCnt);
        }

        System.out.println(groupCnt);
        System.out.println(maxCnt);
        br.close();
    }

    public static int ccw(Loc loc1, Loc loc2, Loc loc3) {
        int result = ((loc1.x * loc2.y) + (loc2.x * loc3.y) + (loc3.x * loc1.y))
                - ((loc1.y * loc2.x) + (loc2.y * loc3.x) + (loc3.y * loc1.x));

        return Integer.compare(result, 0);
    }

    public static void make() {
        parents = new int[N];
        count = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            count[i] = 1;
        }
    }

    public static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }

    public static boolean union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) {
            return false;
        }

        parents[bParent] = aParent;
        count[aParent] += count[bParent];
        return true;
    }

    public static class Line {
        Loc l1, l2;

        public Line(int x1, int y1, int x2, int y2) {
            l1 = new Loc(x1, y1);
            l2 = new Loc(x2, y2);
        }
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
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }
    }
}
