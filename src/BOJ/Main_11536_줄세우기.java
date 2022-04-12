package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11536_줄세우기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ans = "NEITHER";

        int N = Integer.parseInt(br.readLine());
        String temp1 = br.readLine();
        String temp2 = br.readLine();
        int state = temp2.compareTo(temp1);
        for (int i = 2; i < N; i++) {
            String input = br.readLine();

            if (input.compareTo(temp2) < 0) {
                if (state > 0) {
                    state = 0;
                    break;
                }
            } else {
                if (state < 0) {
                    state = 0;
                    break;
                }
            }
            temp2 = input;
        }

        if (state > 0) {
            ans = "INCREASING";
        } else if (state < 0) {
            ans = "DECREASING";
        }

        System.out.println(ans);
        br.close();
    }
}