package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {

    static int L, C;
    static char[] list;
    static char[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = new char[L];

        list = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);

        check(0, 0, 0, 0);

        System.out.println(sb.toString());
        br.close();
    }

    public static void check(int start, int cnt, int vowel, int consonant) {

        if (cnt == L) {
            if (vowel > 0 && consonant > 1) {
                for (char c : ans) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            ans[cnt] = list[i];
            if (checkVowel(list[i])) {
                check(i + 1, cnt + 1, vowel + 1, consonant);
            } else {
                check(i + 1, cnt + 1, vowel, consonant + 1);
            }
        }
    }

    public static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
