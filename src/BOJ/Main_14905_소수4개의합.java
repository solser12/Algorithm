package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_14905_소수4개의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        boolean[] visited = new boolean[100000001];
        init(primeNumbers, visited);

        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);

            if (num >= 8) {
                if (num % 2 == 0) {
                    sb.append("2 2 ");
                    num -= 4;
                } else {
                    sb.append("2 3 ");
                    num -= 5;
                }

                for (int primeNumber : primeNumbers) {
                    if (visited[num - primeNumber]) continue;
                    sb.append(primeNumber).append(' ').append(num - primeNumber).append('\n');
                    break;
                }
            } else {
                sb.append("Impossible.\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void init(ArrayList<Integer> primeNumbers, boolean[] visited) {
        visited[0] = true;
        visited[1] = true;

        for (int i = 2; i <= 100000000; i++) {
            if (visited[i]) continue;
            primeNumbers.add(i);
            for (int j = i + i; j <= 100000000; j += i) {
                visited[j] = true;
            }
        }
    }
}
