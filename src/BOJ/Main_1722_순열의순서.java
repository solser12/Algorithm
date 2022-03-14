package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_순열의순서 {

    public static boolean[] use;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        use = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if (k == 1) {
            findProgression(N, N, Long.parseLong(st.nextToken()) - 1);
        } else {
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            findSequence(N, N, arr, 0);
        }

        System.out.println(sb);
        br.close();
    }

    public static void findSequence(int N, int facto, int[] arr, long sum) {

        if (facto == 0) {
            sb.append(sum + 1);
            return;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (use[i]) continue;
            if (arr[N - facto] == i) {
                use[i] = true;
                findSequence(N, facto - 1, arr, sum + (count * getFactorial(facto - 1)));
                break;
            }
            count++;
        }
    }

    public static void findProgression(int N, int facto, long k) {

        if (facto == 0) return;

        long temp = getFactorial(facto);
        long minus = temp / facto;
        for (int i = N; i >= 1; i--) {
            if (use[i]) continue;
            temp -= minus;
            if (temp <= k) {
                sb.append(i).append(' ');
                use[i] = true;
                findProgression(N, facto - 1, k - temp);
                break;
            }
        }
    }

    public static long getFactorial(int N) {
        if (N == 0) return 0;
        long result = 1;
        for (int i = 2; i <= N; i++) result *= i;
        return result;
    }
}
