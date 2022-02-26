package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int pack = Integer.MAX_VALUE, single = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(Integer.parseInt(st.nextToken()), pack);
            single = Math.min(Integer.parseInt(st.nextToken()), single);
        }

        int ans = 0;
        if (N > 6) {
            int minPrice = Math.min(pack, single * 6);
            ans += minPrice * (N / 6);
            N %= 6;
        }
        ans += Math.min(pack, single * N);

        System.out.println(ans);
        br.close();
    }
}
