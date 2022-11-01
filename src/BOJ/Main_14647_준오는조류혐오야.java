package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14647_준오는조류혐오야 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] countN = new int[n];
        int[] countM = new int[m];

        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String input = st.nextToken();
                int cnt = 0;
                for (int s = 0; s < input.length(); s++) {
                    if (input.charAt(s) == '9') {
                        cnt++;
                    }
                }
                countN[i] += cnt;
                countM[j] += cnt;
                total += cnt;
            }
        }

        int maxCnt = 0;
        for (int i : countN) {
            maxCnt = Math.max(maxCnt, i);
        }
        for (int i : countM) {
            maxCnt = Math.max(maxCnt, i);
        }

        System.out.println(total - maxCnt);
        br.close();
    }
}
