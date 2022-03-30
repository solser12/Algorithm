package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11509_풍선맞추기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1000001];

        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int balloon = Integer.parseInt(st.nextToken());

            if (height[balloon] == 0) {
                ans++;
            } else {
                height[balloon]--;
            }
            height[balloon - 1]++;
        }

        System.out.println(ans);
        br.close();
    }
}
