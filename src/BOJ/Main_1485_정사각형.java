package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1485_정사각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            Point[] points = new Point[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            double[] len = new double[6];
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    len[idx++] = Math.sqrt(square(points[i].x - points[j].x) + square(points[i].y - points[j].y));
                }
            }
            Arrays.sort(len);

            if (len[0] == len[1] && len[1] == len[2] && len[2] == len[3] && len[4] == len[5]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static long square(int a) {
        return (long) a * a;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
