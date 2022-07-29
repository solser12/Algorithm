package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8979_올림픽 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nations[i] = new Nation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nations);

        if (nations[0].num == k) {
            System.out.println(1);
        } else {
            int sameCnt = 0;
            for (int i = 1; i < n; i++) {
                if (nations[i].compareTo(nations[i - 1]) == 0) {
                    sameCnt++;
                } else {
                    sameCnt = 0;
                }

                if (nations[i].num == k) {
                    System.out.println(i - sameCnt + 1);
                    break;
                }
            }
        }

        br.close();
    }

    public static class Nation implements Comparable<Nation> {

        int num, gold, silver, bronze;

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}
