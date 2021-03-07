package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기v2 {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int a = (N-1) / 4;
            int b = (M-1) / 4;

            int n = (N-1) % 4 != 0 ? (4 * (a+1)) / 2 : ((4 * (a+1)) / 2) - 1;
            int m = (M-1) % 4 != 0 ? (4 * (b+1)) / 2 : ((4 * (b+1)) / 2) - 1;

            int ans = n * m + (M - m) * (N - n);
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}

/*
1 1
2 2
3 2
4 2

5 3
6 4
7 4
8 4

9 5
10 6
11 6
12 6
 */