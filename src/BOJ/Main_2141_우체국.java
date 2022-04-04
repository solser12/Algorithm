package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2141_우체국 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Village[] villages = new Village[N];
        long totalCnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int loc = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            totalCnt += count;
            villages[i] = new Village(loc, count);
        }
        Arrays.sort(villages);

        int ans = -1000000000;
        if (totalCnt > 0) {
            long tempCnt = 0;
            for (Village village : villages) {
                tempCnt += village.count;
                if (totalCnt / 2.0 <= tempCnt) {
                    ans = village.loc;
                    break;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Village implements Comparable<Village> {
        int loc, count;

        public Village(int loc, int count) {
            this.loc = loc;
            this.count = count;
        }

        @Override
        public int compareTo(Village o) {
            return this.loc - o.loc;
        }
    }
}
