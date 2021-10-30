package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10973_이전순열 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prePermutation()) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(' ');
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean prePermutation() {

        int i = N - 1;
        while (i > 0 && arr[i - 1] <= arr[i]) i--;
        if (i == 0) return false;

        int j = N - 1;
        while (arr[i - 1] <= arr[j]) j--;

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = N - 1;
        while (i < j) {
            temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }

        return true;
    }
}
