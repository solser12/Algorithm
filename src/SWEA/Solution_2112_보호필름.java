package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {

    static int D, W, K;
    static boolean[][] film, tFilm;
    static int change;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new boolean[D][W];
            tFilm = new boolean[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        film[i][j] = true;
                        tFilm[i][j] = true;
                    }
                }
            }

            for (int i = 0; i <= D; i++) {
                change = i;
                if (check(0, 0)) break;
            }

            sb.append('#').append(t).append(' ').append(change).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static boolean check(int mem, int cnt) {

        if (mem == D)
            return change == cnt && isPass();


        // 변경 기회가 남았는지 확인
        if (cnt < change) {
            // A로 바꾸기
            Arrays.fill(tFilm[mem], false);
            if (check(mem + 1, cnt + 1)) return true;
            tFilm[mem] = film[mem].clone();

            // B로 바꾸기
            Arrays.fill(tFilm[mem], true);
            if (check(mem + 1, cnt + 1)) return true;
            tFilm[mem] = film[mem].clone();
        }

        // 안바꾸고 보내기
        if (check(mem + 1, cnt)) return true;

        return false;
    }

    static boolean isPass() {
        int cnt;
        boolean check;

        for (int i = 0; i < W; i++) {
            cnt = 0;
            check = tFilm[0][i];
            for (int j = 0; j < D; j++) {
                if (tFilm[j][i] == check) {
                    cnt++;
                    if (cnt == K) break;
                }
                else {
                    cnt = 1;
                    check = tFilm[j][i];
                }
                if (j == D - 1) return false;
            }
        }
        return true;
    }
}
