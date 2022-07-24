package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1475_방번호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] number = br.readLine().toCharArray();
        HashMap<Character, Integer> numberCount = new HashMap<>();
        for (int i = 0; i <= 8; i++) {
            numberCount.put((char) ('0' + i), 0);
        }

        int ans = 0;
        for (char c : number) {
            if (c == '9') {
                c = '6';
            }

            int count = numberCount.get(c) + 1;
            numberCount.put(c, count);
            ans = Math.max(ans, c == '6' ? (count + 1) / 2 : count);
        }

        System.out.println(ans);
        br.close();
    }
}