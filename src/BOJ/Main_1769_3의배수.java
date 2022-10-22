package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1769_3의배수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int cnt = 0;
        while (str.length() > 1) {
            int temp = 0;
            for (int i = 0; i < str.length(); i++) {
                temp += str.charAt(i) - '0';
            }
            str = String.valueOf(temp);
            cnt++;
        }

        int num = Integer.parseInt(str);
        System.out.println(cnt);
        System.out.println(num % 3 == 0 ? "YES" : "NO");
        br.close();
    }
}
