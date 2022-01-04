package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12781_PIZZAALVOLOC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] points = new Point[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if (ccw(points[0], points[1], points[2]) * ccw(points[0], points[1], points[3]) < 0
                && ccw(points[2], points[3], points[0]) * ccw(points[2], points[3], points[1]) < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    public static int ccw(Point p1, Point p2, Point p3) {
        int result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y))
                - ((p1.x * p3.y) + (p2.x * p1.y) + (p3.x * p2.y));

        return Integer.compare(result, 0);
    }
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
