package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1032_명령_프롬프트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != str.charAt(j)) {
                    arr[j] = '?';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        System.out.println(sb);
        br.close();
    }
}