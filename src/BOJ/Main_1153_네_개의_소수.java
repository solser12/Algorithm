package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1153_네_개의_소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N >= 8) {
            int[] ans = new int[4];
            sb.append('2').append(' ');
            if (N % 2 == 0) {
                sb.append('2').append(' ');
                N -= 4;
            } else {
                sb.append('3').append(' ');
                N -= 5;
            }

            boolean[] visited = new boolean[N + 1];
            ArrayList<Integer> primeNumber = makePrimeNumber(N, visited);

            for (int prime : primeNumber) {
                if (visited[N - prime]) continue;
                sb.append(prime).append(' ').append(N - prime);
                break;
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }

    public static ArrayList<Integer> makePrimeNumber(int N, boolean[] visited) {
        ArrayList<Integer> result = new ArrayList<>();
        visited[0] = true;
        visited[1] = true;
        for (int i = 2; i <= N; i++) {
            if (visited[i]) continue;
            result.add(i);
            for (int j = i + i; j <= N; j += i) {
                visited[j] = true;
            }
        }
        return result;
    }
}
