package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {

    static int N, r, c;
    static long cnt = 0;
    static int[] d = {0 , 0, 0, 1, 1, 0, 1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Start(0, 0, (int)Math.pow(2, N));

        br.close();
    }

    static void Start(int x, int y, int n) {

        if (n == 2) {
            for (int i = 0; i < d.length; i+=2) {
                if (x + d[i] == r && y + d[i+1] == c) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
            return;
        }

        int div = n / 2;
        int xdiv = x + div;
        int ydiv = y + div;

        if (xdiv > r && ydiv > c) {
            Start(x, y, div);
        }
        else if (xdiv > r && ydiv <= c) {
            cnt += div * div;
            Start(x, ydiv, div);
        }
        else if (xdiv <= r && ydiv > c) {
            cnt += div * div * 2;
            Start(xdiv, y, div);
        }
        else {
            cnt += div * div * 3;
            Start(xdiv, ydiv, div);
        }
    }
}
