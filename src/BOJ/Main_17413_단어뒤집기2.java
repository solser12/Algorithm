package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int len = input.length(), index = 0, start = -1;
        boolean flag = false;

        while (index < len) {
            char c = input.charAt(index);
            if (flag) {
                if (c == '>') {
                    flag = false;
                    start = index;
                }
                sb.append(c);
            } else {
                if (c == '<') {
                    flag = true;
                    sb.append(new StringBuilder().append(input, start + 1, index).reverse()).append('<');
                } else {
                    if (c == ' ') {
                        sb.append(new StringBuilder().append(input, start + 1, index).reverse()).append(' ');
                        start = index;
                    }
                }
            }
            index++;
        }

        if (start != len) {
            sb.append(new StringBuilder().append(input, start + 1, len).reverse());
        }

        System.out.println(sb);
        br.close();
    }
}
