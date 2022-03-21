package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1393_음하철도구구팔 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys  = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());
        int gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;

        double len = calcDist(xs - xe, ys - ye);
        int ansX = xe, ansY = ye, tempX = xe + dx, tempY = ye + dy;
        while (true) {
            double temp = calcDist(tempX - xs, tempY - ys);
            if (len <= temp) break;

            len = temp;
            ansX = tempX;
            ansY = tempY;
            tempX += dx;
            tempY += dy;
        }

        System.out.println(ansX + " " + ansY);
        br.close();
    }

    public static double calcDist(int x, int y) {
        return Math.sqrt((x * x) + (y * y));
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
