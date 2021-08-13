package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16967_배열복원하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());


        int[][] A = new int[H][W];

        int tempX = 0, tempY = 0;

        for (int i = 0;  i < H + X; i++) {

            String input = br.readLine();
            if (tempX == H) continue;

            st = new StringTokenizer(input);
            for (int j = 0; j < W + Y; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 필요없는 부분
                if ((i >= H && j < Y) || (i < X & j >= W)) {
                    continue;
                }

                if (i < H && j < W) {
                    if (i >= X && j >= Y) {
                        // 겹치기 시작
                        A[i][j] = num - A[tempX][tempY];
                    } else {
                        A[i][j] = num;
                    }
                }

                if (i >= X && j >= Y) {
                    tempY++;
                    if (tempY == W) {
                        tempX++;
                        tempY = 0;
                    }
                }
            }
        }

        for (int[] ints : A) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
