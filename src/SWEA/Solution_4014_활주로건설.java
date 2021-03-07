package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {

    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            int ans = 0;
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                if (checkVert(i)) ans++;
                if (checkHori(i)) ans++;
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static boolean checkVert(int start) {
        int point, last;
        boolean[] ramp = new boolean[N];
        for (int i = 1; i < N;) {
            point = map[start][i];
            last = map[start][i-1];

            if (point + 1 == last)  {       // 낮아진 경우
                for (int j = i; j < i + X; j++) {
                    if ( j < N && map[start][j] == point && !ramp[j]) {
                        ramp[j] = true;
                        continue;
                    }
                    return false;
                }
                i += X;
            }
            else if (point == last + 1) {   // 높아진 경우
                for (int j = i - 1; j > i - X - 1; j--) {
                    if ( j >= 0 && map[start][j] == last && !ramp[j]) {
                        ramp[j] = true;
                        continue;
                    }
                    return false;
                }
                i++;
            }
            else if (point == last) {       // 같은 경우
                i++;
            }
            else return false;
        }

        return true;
    }

    static boolean checkHori(int start) {
        int point, last;
        boolean[] ramp = new boolean[N];
        for (int i = 1; i < N;) {
            point = map[i][start];
            last = map[i-1][start];

            if (point + 1 == last)  {       // 낮아진 경우
                for (int j = i; j < i + X; j++) {
                    if ( j < N && map[j][start] == point && !ramp[j]) {
                        ramp[j] = true;
                        continue;
                    }
                    return false;
                }
                i += X;
            }
            else if (point == last + 1) {   // 높아진 경우
                for (int j = i - 1; j > i - X - 1; j--) {
                    if ( j >= 0 && map[j][start] == last && !ramp[j]) {
                        ramp[j] = true;
                        continue;
                    }
                    return false;
                }
                i++;
            }
            else if (point == last) {       // 같은 경우
                i++;
            }
            else return false;
        }

        return true;
    }
}
