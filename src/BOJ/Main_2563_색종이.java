package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

    static int N;
    static boolean[][] paper;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            add(x, y);
        }

        System.out.println(cnt);
        br.close();
    }

    static void add(int x, int y) {
        for (int i = x; i < x+10; i++) {
            for (int j = y; j < y+10; j++) {
                if (!paper[i][j]) {
                    paper[i][j] = true;
                    cnt++;
                }
            }
        }
    }
}
