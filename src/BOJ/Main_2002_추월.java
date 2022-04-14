package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_2002_추월 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), i);
        }

        int[] out = new int[N];
        for (int i = 0; i < N; i++) {
            out[i] = map.get(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (out[i] > out[j]) {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}
