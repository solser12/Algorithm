package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20149_선분교차3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Loc loc1 = new Loc(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Loc loc2 = new Loc(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Loc loc3 = new Loc(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Loc loc4 = new Loc(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

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
                System.out.println(1);
                checkIntersection(loc1, loc2, loc3, loc4);
            } else {
                System.out.println(0);
            }

        } else if (result1 <= 0 && result2 <= 0) {
            System.out.println(1);
            checkIntersection(loc1, loc2, loc3, loc4);
        } else {
            System.out.println(0);
        }
        
        
        br.close();
    }

    public static void checkIntersection(Loc loc1, Loc loc2, Loc loc3, Loc loc4) {

        double d = ((loc1.x - loc2.x) * (loc3.y - loc4.y)) - ((loc1.y - loc2.y) * (loc3.x - loc4.x));

        if (d == 0) {
            if (loc1.compareTo(loc4) == 0 && loc3.compareTo(loc1) <= 0) {
                System.out.println(loc1.x + " " + loc1.y);
            } else if (loc2.compareTo(loc3) == 0 && loc1.compareTo(loc3) <= 0) {
                System.out.println(loc2.x + " " + loc2.y);
            }
        } else {
            double px = (((loc1.x * loc2.y - loc1.y * loc2.x) * (loc3.x - loc4.x))
                    - ((loc3.x * loc4.y - loc3.y * loc4.x) * (loc1.x -loc2.x))) / d;
            double py = (((loc1.x * loc2.y - loc1.y * loc2.x) * (loc3.y - loc4.y))
                    - ((loc3.x * loc4.y - loc3.y * loc4.x) * (loc1.y - loc2.y))) / d;
            System.out.println(px + " " + py);
        }
    }

    public static int ccw(Loc loc1, Loc loc2, Loc loc3) {
        long result = ((loc1.x * loc2.y) + (loc2.x * loc3.y) + (loc3.x * loc1.y))
                - ((loc1.y * loc2.x) + (loc2.y * loc3.x) + (loc3.y * loc1.x));

        return Long.compare(result, 0);
    }

    public static class Loc implements Comparable<Loc> {
        long x, y;

        public Loc(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Loc o) {
            if (this.x == o.x) return Long.compare(this.y, o.y);
            return Long.compare(this.x, o.x);
        }
    }
}
