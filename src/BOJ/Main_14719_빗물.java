package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blocks = new int[W];
        int[] rain = new int[W];
        st = new StringTokenizer(br.readLine());

        int height = 0;
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            height = Math.max(height, blocks[i]);
            rain[i] = height;
        }

        height = 0;
        int ans = 0;
        for (int i = W - 1; i >= 0; i--) {
            height = Math.max(height, blocks[i]);
            rain[i] = Math.min(height, rain[i]);
            ans += rain[i] - blocks[i];
        }

        System.out.println(ans);
        br.close();
    }
}
