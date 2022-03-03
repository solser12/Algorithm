package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986_나머지합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int[] modCount = new int[M];
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            sum %= M;
            modCount[sum]++;
        }

        long ans = modCount[0];
        for (int c : modCount) {
            if (c == 0) continue;
            ans += ((long) c * (c - 1)) / 2;
        }

        System.out.println(ans);
        br.close();
    }
}
