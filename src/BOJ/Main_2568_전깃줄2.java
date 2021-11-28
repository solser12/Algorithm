package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2568_전깃줄2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] dp = new int[N];
        int[] visited = new int[N];
        int dpIndex = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int maxIndex = 0;
        dp[0] = arr[0][1];
        visited[0] = 0;
        for (int i = 1; i < N; i++) {
            if (dp[dpIndex - 1] < arr[i][1]) {
                visited[i] = dpIndex;
                dp[dpIndex++] = arr[i][1];
            } else {
                int index = binarySearch(dp, dpIndex, arr[i][1]);
                dp[index] = arr[i][1];
                visited[i] = index;
            }
            maxIndex = Math.max(maxIndex, visited[i]);
        }

        int delSize = N - dpIndex;
        Stack stack = new Stack(delSize);
        for (int i = N - 1; i >= 0; i--) {
            if (visited[i] == maxIndex) {
                maxIndex--;
            } else {
                stack.push(arr[i][0]);
            }
        }

        sb.append(delSize).append('\n');
        for (int i = 0; i < delSize; i++) {
            sb.append(stack.pop()).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        int[] arr;
        int index;

        public Stack(int size) {
            arr = new int[size];
            index = 0;
        }

        public void push(int num) {
            arr[index++] = num;
        }

        public int pop() {
            return arr[--index];
        }
    }

    public static int binarySearch(int[] arr, int index, int num) {
        int left = -1, right = index - 1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < num) left = mid;
            else right = mid;
        }
        return right;
    }
}
