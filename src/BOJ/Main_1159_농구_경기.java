package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1159_농구_경기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cnt[br.readLine().charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }

        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }

        br.close();
    }
}
