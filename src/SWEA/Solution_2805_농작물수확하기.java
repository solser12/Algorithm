package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2805_농작물수확하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, sum;
        int[][] farm;

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            farm = new int[N][N];
            sum = 0;

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = input.charAt(j) - '0';
                }
            }

            for (int i = 0; i <= N/2; i++) {
                for (int j = 0; j < 1+2*i; j++) {
                    sum += farm[i][N/2+j-i];
                }
            }

            for (int i = N-1; i > N/2; i--) {
                for (int j = 0; j < 1+2*(N-i-1); j++) {
                    sum += farm[i][N/2+j-(N-i-1)];
                }
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}