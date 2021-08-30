package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_회전초밥 {

    static int N, d, k ,c;
    static int[] sushi, choice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()) - 1;
        int ans = 0;

        sushi = new int[N*2];
        choice = new int[d];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            sushi[i] = num;
            sushi[i+N] = num;
        }

        int overlap = 0;
        int start = 0, end = k;
        for (int i = 0; i < k; i++) {
            choice[sushi[i]]++;
            if (choice[sushi[i]] > 1) overlap++;
        }

        while (start < N) {
            ans = Math.max(ans, end - start - overlap + (choice[c] == 0 ? 1: 0));

            if (choice[sushi[start]] > 1) overlap--;
            choice[sushi[start]]--;
            start++;

            choice[sushi[end]]++;
            if (choice[sushi[end]] > 1) overlap++;
            end++;
        }

        System.out.println(ans);
        br.close();
    }
}
