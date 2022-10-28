package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_5555_반지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pattern = ".*" + str + ".*";
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            ring += ring;
            if (Pattern.matches(pattern, ring)) {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
