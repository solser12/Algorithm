package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_1316_그룹단어체커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (check(br.readLine())) {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(String s) {

        HashSet<Character> set = new HashSet<>();
        char now = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (now != c) {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
                now = c;
            }
        }

        return true;
    }
}
