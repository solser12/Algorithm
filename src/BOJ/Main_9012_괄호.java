package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9012_괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (check(br.readLine())) sb.append("YES");
            else sb.append("NO");
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean check(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) return false;
                count--;
            }
        }

        return count == 0;
    }
}
