package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3135_라디오 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = Math.abs(A - B);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, Math.abs(Integer.parseInt(br.readLine()) - B) + 1);
        }

        System.out.println(ans);
        br.close();
    }
}