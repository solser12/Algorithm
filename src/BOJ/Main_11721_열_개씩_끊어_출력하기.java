package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11721_열_개씩_끊어_출력하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int size = 10;
        while (size <= str.length()) {
            sb.append(str, size - 10, size).append('\n');
            size += 10;
        }

        sb.append(str.substring(size - 10)).append('\n');

        System.out.print(sb);
        br.close();
    }
}
