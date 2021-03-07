package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class Solution_1954_달팽이숫자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, sw, cnt, temp;
        int[][] snail;
        int[] loc = new int[2];

        for (int t = 1; t <= T; ++t) {

        	N = Integer.parseInt(br.readLine());
        	snail = new int[N][N];
        	sw = 1;
        	cnt = 1;
        	loc[0] = 0;
        	loc[1] = 0;

        	for (int i = N*2; i >= 1; i--) {
        		for ( int j = 0; j < i/2; j++) {
        			if (i % 2 == 0) {	// 가로
        				snail[loc[0]][loc[1]+j*sw] = cnt++;
        			}
        			else {				// 세로
        				snail[loc[0]+j*sw][loc[1]] = cnt++;
        			}
        		}

        		if (i % 2 == 0) {
        			loc[1] += sw * (i/2 - 1);
        			loc[0] += sw;
        		}
        		else {
        			loc[0] += sw * (i/2 - 1);
        			sw *= -1;
        			loc[1] += sw;
        		}
        	}

			sb.append("#").append(t).append("\n");

        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			sb.append(snail[i][j]).append(" ");
        		}
        		sb.append("\n");
        	}
        }

		bw.write(sb.toString());

        br.close();
        bw.close();
    }
}