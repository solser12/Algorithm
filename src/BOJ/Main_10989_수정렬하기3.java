package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] count = new int[10001];
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }
}
