package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1969_DNA {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] dna = new char[m][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                dna[j][i] = input.charAt(j);
            }
        }

        char[] ans = new char[m];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int[] dnaCnt = new int[4];
            for (int j = 0; j < n; j++) {
                if (dna[i][j] == 'A') {
                    dnaCnt[0]++;
                } else if (dna[i][j] == 'C') {
                    dnaCnt[1]++;
                } else if (dna[i][j] == 'G') {
                    dnaCnt[2]++;
                } else {
                    dnaCnt[3]++;
                }
            }
            Result result = check(dnaCnt);
            ans[i] = result.c;
            cnt += result.cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ans) {
            sb.append(c);
        }
        sb.append('\n').append(cnt);

        System.out.println(sb);
        br.close();
    }

    public static Result check(int[] count) {
        char c = ' ';
        int sum = 0, max;
        for (int i : count) {
            sum += i;
        }
        max = sum;

        for (int i = 0; i < 4; i++) {
            sum -= count[i];
            if (sum < max) {
                max = sum;
                c = i == 0 ? 'A' : (i == 1 ? 'C' : (i == 2 ? 'G' : 'T'));
            }
            sum += count[i];
        }

        return new Result(c, max);
    }

    public static class Result {
        char c;
        int cnt;

        public Result(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
