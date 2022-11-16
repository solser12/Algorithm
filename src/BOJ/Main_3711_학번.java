package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3711_학번 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int num = 1;
            int[] check = new int[1000000];
            while (true) {
                boolean isSame = false;
                for (int i : arr) {
                    int temp = i % num;
                    if (check[temp] == num) {
                        isSame = true;
                        break;
                    }
                    check[temp] = num;
                }
                if (!isSame) {
                    break;
                }
                num++;
            }
            System.out.println(num);
        }

        br.close();
    }
}
