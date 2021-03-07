package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {

    static int N, ans = 0;
    static int[][] recode;
    static int[] order = {0, 1, 2, 4, 5, 6, 7, 8};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recode = new int[N][9];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                recode[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        do {
            gameStart();
        } while (nextPermutation());

        System.out.println(ans);
        br.close();
    }

    static void gameStart() {
        int[] inning = new int[9];
        int base, out, batter = 0, point = 0;

        for(int in = 0; in < N; in++) {
            // 이닝 초기화
            base = 0;
            out = 0;

            while(out != 3) {
                // 타자 순서 대로 넣기
                inning[3] = recode[in][0];
                for (int i = 1; i < 9; i++) {
                    inning[order[i-1]] = recode[in][i];
                }

                // 게임 시작
                int state = inning[batter];
                batter = (batter + 1) % 9;

                if (state == 0) {
                    out++;
                    continue;
                }

                base += 1;

                for (int i = 0; i < state; i++) {
                    if (i == 3) {
                        point++;
                    }
                    else if ((base & (1 << (3 - i))) != 0) {
                        point++;
                    }
                }

                base <<= state;
            }
            ans = Math.max(ans, point);
        }
    }

    static boolean nextPermutation() {

        int i = 7;
        while (i > 0 && order[i-1] >= order[i]) --i;
        if (i == 0) return false;

        int j = 7;
        while (order[i-1] >= order[j]) --j;

        int temp = order[i-1];
        order[i-1] = order[j];
        order[j] = temp;

        j = 7;
        while(i < j) {
            temp = order[i];
            order[i++] = order[j];
            order[j--] = temp;
        }

        return true;
    }
}
