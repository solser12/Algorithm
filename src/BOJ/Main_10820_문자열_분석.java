package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10820_문자열_분석 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int lower = 0, upper = 0, number = 0, space = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (Character.isUpperCase(c)) {
                    upper++;
                } else if (Character.isLowerCase(c)) {
                    lower++;
                } else if (Character.isDigit(c)) {
                    number++;
                } else {
                    space++;
                }
            }
            sb.append(lower).append(' ').append(upper).append(' ').append(number).append(' ').append(space).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
