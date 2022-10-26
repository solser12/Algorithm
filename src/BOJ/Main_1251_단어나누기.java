package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1251_단어나누기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String ans = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String temp = program(str.substring(0, i), str.substring(i, j), str.substring(j));
                ans = ans.compareTo(temp) > 0 ? temp : ans;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static String program(String str1, String str2, String str3) {
        return String.valueOf(new StringBuilder(str1).reverse())
                + new StringBuilder(str2).reverse()
                + new StringBuilder(str3).reverse();
    }
}