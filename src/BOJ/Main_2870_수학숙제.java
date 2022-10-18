package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main_2870_수학숙제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (String s : br.readLine().split("\\D")) {
                if (s.length() > 0) {
                    ans.add(new BigInteger(s));
                }
            }
        }
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (BigInteger i : ans) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
