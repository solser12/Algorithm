package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543_문서검색 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String find = br.readLine();

        int ans = 0, left = 0;
        while (left < document.length() - find.length() + 1) {
            if (find.equals(document.substring(left, left + find.length()))) {
                ans++;
                left = left + find.length();
            } else {
                left++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}