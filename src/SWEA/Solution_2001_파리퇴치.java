package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	
	public static void main(String[] args) throws IOException {
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int sum = 0, max = -1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    for (int m = i; m < i+M; m++) {
                        for (int n = j; n < j+M; n++) {
                            sum += map[m][n];
                        }
                    }
                    max = Math.max(sum, max);
                    sum = 0;
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
	}
}
