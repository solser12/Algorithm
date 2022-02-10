package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11585_속타는저녁메뉴 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] meat = new char[N];
        char[] roulette = new char[N + N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            meat[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            roulette[i] = st.nextToken().charAt(0);
        }
        for (int i = 0; i < N - 1; i++) {
            roulette[i + N] = roulette[i];
        }

        int cnt = find(N, roulette, meat, makeTable(N, meat));
        int div = euclideanAlgorithm(N, cnt);

        System.out.println((cnt / div) + "/" + (N / div));
        br.close();
    }

    public static int euclideanAlgorithm(int a, int b) {
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static int find(int N, char[] roulette, char[] meat, int[] table) {
        int i = 0, cnt = 0;
        for (char c : roulette) {
            while (i > 0 && c != meat[i]) {
                i = table[i - 1];
            }
            if (c == meat[i]) {
                if (i == N - 1) {
                    i = table[i];
                    cnt++;
                } else {
                    i++;
                }
            }
        }
        return cnt;
    }

    public static int[] makeTable(int N, char[] meat) {
        int[] table = new int[N];
        int j = 0;
        for (int i = 1; i < N; i++) {
            while (j > 0 && meat[i] != meat[j]) {
                j = table[j - 1];
            }
            if (meat[i] == meat[j]) {
                table[i] = ++j;
            }
        }
        return table;
    }
}
