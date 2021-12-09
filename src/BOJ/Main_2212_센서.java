package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_센서 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensors = new int[N];
        int[] dist = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        for (int i = 0; i < N - 1; i++) {
            dist[i] = sensors[i + 1] - sensors[i];
        }
        Arrays.sort(dist);

        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += dist[i];
        }

        System.out.println(ans);
        br.close();
    }
}
