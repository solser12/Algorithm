package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9093_단어_뒤집기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            for (int i = 0; i < size; i++) {
                sb.append(new StringBuilder(st.nextToken()).reverse()).append(' ');
            }
            sb.setLength(sb.length() - 1);
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
