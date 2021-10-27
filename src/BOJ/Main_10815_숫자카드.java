package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {

    static int N, M;
    static int[] myCards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        myCards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(myCards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static int binarySearch(int num) {
        int left = -1, right = N - 1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (myCards[mid] >= num) right = mid;
            else left = mid;
        }

        return myCards[right] == num ? 1 : 0;
    }
}
