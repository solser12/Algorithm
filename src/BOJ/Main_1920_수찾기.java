package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()))).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int binarySearch(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = arr[mid];

            if (midVal < key) {
                left = mid + 1;
            } else if (midVal > key) {
                right = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
