package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9009_피보나치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> fibo = new ArrayList<>();
            fibo.add(1);
            fibo.add(1);
            int index = 1;
            while (true) {
                int num = fibo.get(index - 1) + fibo.get(index);
                if (num > n) break;
                fibo.add(num);
                index++;
            }

            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = index; i >= 0; i--) {
                if (n < fibo.get(i)) continue;
                n -= fibo.get(i);
                temp.add(fibo.get(i));
            }

            for (int i = temp.size() - 1; i >= 0; i--) {
                sb.append(temp.get(i)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
