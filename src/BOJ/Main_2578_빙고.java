package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {

    static int[][] chul = new int[5][5];
    static int[][] loc = new int[26][2];
    static int[] input = new int[25];
    static int[][] di = {{1, -1}, {0, 0}, {1, -1}, {1, -1}};
    static int[][] dj = {{0, 0}, {1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                chul[i][j] = Integer.parseInt(st.nextToken());
                loc[chul[i][j]][0] = i;
                loc[chul[i][j]][1] = j;
            }
        }

        for (int i = 0; i < 25;) {
            st = new StringTokenizer(br.readLine());
            for (int j = i; i < j+5; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
        }

        int bingo = 0;

        for(int cnt = 0; cnt < 25; cnt++) {
            int num = input[cnt];
            chul[loc[num][0]][loc[num][1]] = 0;

            if(cnt >= 4) bingo += checking(num);
            if (bingo >= 3) {
                System.out.println(cnt+1);
                break;
            }
        }

        br.close();
    }

    static int checking (int num) {
        int x = loc[num][0];
        int y = loc[num][1];
        int bingo = 0;

        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int d = 0; d < 2; d++) {
                int dx = x;
                int dy = y;
                while(true) {
                    dx += di[i][d];
                    dy += dj[i][d];
                    if (dx >= 0 && dx < 5 && dy >= 0 && dy < 5 && chul[dx][dy] == 0) cnt++;
                    else break;
                }
            }
            if (cnt == 4) bingo++;
        }

        return bingo;
    }
}
