package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10255_교차점 {

    public static int cornerCnt, normalCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            cornerCnt = 0;
            normalCnt = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Loc lb = new Loc(x1, y1);
            Loc lt = new Loc(x1, y2);
            Loc rt = new Loc(x2, y2);
            Loc rb = new Loc(x2, y1);
            Line[] rectangle = new Line[4];
            rectangle[0] = new Line(lb, lt);
            rectangle[1] = new Line(lt, rt);
            rectangle[2] = new Line(rb, rt);
            rectangle[3] = new Line(lb, rb);

            st = new StringTokenizer(br.readLine());
            Loc loc1 = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Loc loc2 = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            if (loc1.compareTo(loc2) > 0) {
                Loc temp = loc1;
                loc1 = loc2;
                loc2 = temp;
            }
            Line line = new Line(loc1, loc2);

            for (Line l : rectangle) {
                check(line, l);
                if (normalCnt >= 100) {
                    normalCnt = 4;
                    cornerCnt = 0;
                    break;
                }
            }
            sb.append(normalCnt + (cornerCnt / 2)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void check(Line line, Line rec) {

        int a1 = ccw(rec.loc1, rec.loc2, line.loc1);
        int a2 = ccw(rec.loc1, rec.loc2, line.loc2);
        int b1 = ccw(line.loc1, line.loc2, rec.loc1);
        int b2 = ccw(line.loc1, line.loc2, rec.loc2);
        int result1 = a1 * a2;
        int result2 = b1 * b2;

        if (result1 == 0 && result2 == 0) {
            if (line.loc1.compareTo(rec.loc2) <= 0 && rec.loc1.compareTo(line.loc2) <= 0) {
                if (b1 == 0 && b2 == 0) {
                    if ((line.loc1.compareTo(rec.loc2) == 0 && rec.loc1.compareTo(line.loc1) <= 0)
                            || (line.loc2.compareTo(rec.loc1) == 0 && line.loc1.compareTo(rec.loc1) <= 0)) {
                        cornerCnt++;
                    } else {
                        normalCnt = 100;
                    }
                } else if (b1 == 0) {
                    cornerCnt++;
                } else if (b2 == 0) {
                    cornerCnt++;
                }
            }
        } else if (result1 <= 0 && result2 <= 0) {
            if (result2 == 0) {
                if (b1 == 0) {
                    cornerCnt++;
                } else if (b2 == 0) {
                    cornerCnt++;
                }
            } else {
                normalCnt++;
            }
        }
    }

    public static int ccw(Loc loc1, Loc loc2, Loc loc3) {
        int result = ((loc1.x * loc2.y) + (loc2.x * loc3.y) + (loc3.x * loc1.y))
                - ((loc1.y * loc2.x) + (loc2.y * loc3.x) + (loc3.y * loc1.x));

        return Integer.compare(result, 0);
    }

    public static class Line {

        Loc loc1, loc2;

        public Line(Loc loc1, Loc loc2) {
            this.loc1 = loc1;
            this.loc2 = loc2;
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
