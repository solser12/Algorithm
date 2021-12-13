package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1461_도서관 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) plus.add(num);
            else minus.add(num * -1);
        }
        plus.sort(Collections.reverseOrder());
        minus.sort(Collections.reverseOrder());

        ArrayList<Integer> first, last;
        if (plus.size() == 0) {
            first = plus;
            last = minus;
        } else if (minus.size() == 0) {
            first = minus;
            last = plus;
        } else {
            if (plus.get(0) < minus.get(0)) {
                first = plus;
                last = minus;
            } else {
                first = minus;
                last = plus;
            }
        }

        int ans = 0;
        for (int i = 0; i < first.size(); i += M) {
            ans += first.get(i) * 2;
        }

        ans -= last.get(0);
        for (int i = 0; i < last.size(); i += M) {
            ans += last.get(i) * 2;
        }

        System.out.println(ans);
        br.close();
    }
}
