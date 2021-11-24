package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19543_던전지도 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map[] map = new Map[K];
        for (int i = 0; i < K; i++) {
            map[i] = new Map(M, br.readLine());
        }

        String input = br.readLine();
        int left = start(map[input.charAt(input.length() - 1) - 'A'].arr);
        int right = M - 1;
        long ans = right - left + 1;
        for (int i = N - 2; i >= 0; i--) {
            int num = input.charAt(i) - 'A';
            left = map[num].leftArr[left];
            right = map[num].rightArr[right];

            if (left > right) break;
            ans += right - left + 1;
        }

        System.out.println(ans);
        br.close();
    }

    public static int start(char[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] == 'U') return i + 1;
        }
        return 0;
    }

    public static class Map {
        char[] arr;
        int[] leftArr, rightArr;

        public Map(int M, String input) {
            arr = input.toCharArray();
            leftArr = new int[M];
            rightArr = new int[M];
            int leftIndex = 0;
            int rightIndex = -1;
            for (int i = 0; i < M; i++) {
                if (input.charAt(i) == 'U') {
                    leftArr[i] = leftIndex;
                    leftIndex = i + 1;
                    rightIndex = i;
                } else {
                    leftArr[i] = leftIndex;
                }
                rightArr[i] = rightIndex;
            }
        }
    }
}
