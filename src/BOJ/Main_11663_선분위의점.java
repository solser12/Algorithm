package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11663_선분위의점 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        arr[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());
            int front = binarySearch(temp);
            int back = binarySearch(Integer.parseInt(st.nextToken()));
            sb.append(back - front + (arr[front] == temp ? 1 : 0)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int binarySearch(int num) {
        int left = 0, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (num < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
