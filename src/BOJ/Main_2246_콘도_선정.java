package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2246_콘도_선정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Condo[] distArr = new Condo[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            distArr[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(distArr);

        int ans = 0, distMinPrice = Integer.MAX_VALUE;
        for (Condo condo : distArr) {
            if (condo.price < distMinPrice) {
                distMinPrice = condo.price;
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static class Condo implements Comparable<Condo> {

        int dist, price;

        public Condo(int dist, int price) {
            this.dist = dist;
            this.price = price;
        }

        @Override
        public int compareTo(Condo o) {
            if (this.dist == o.dist) {
                return this.price - o.price;
            }
            return this.dist - o.dist;
        }
    }
}
