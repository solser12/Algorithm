package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5607_Professional조합 {

    static final long P = 1234567891;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            long[] facto = new long[N+1];
            facto[1] = 1;

            for (int i = 2; i <= N; i++) facto[i] = (facto[i-1] * i) % P;

            // n!(k!*(n-k)!)
            long ans = (facto[N] * pow((facto[K] * facto[N-K]) % P, P-2)) % P;

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static long pow(long nk, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
                long temp = pow(nk, n / 2) % P;
                return (temp * temp) % P;
    }
        else return (pow(nk, n-1)*nk) % P;
    }
}
