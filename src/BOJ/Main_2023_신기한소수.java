package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수 {

    public static int N;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 2; i <= 7; i++) {
            if (check(i)) {
                dfs(i, 1);
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int num, int depth) {

        if (depth == N) {
            sb.append(num).append('\n');
            return;
        }

        int temp = num * 10;
        for (int i = 1; i <= 9; i += 2) {
            int newNum = temp + i;
            if (check(newNum)) {
                dfs(newNum, depth + 1);
            }
        }
    }

    public static boolean check(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
