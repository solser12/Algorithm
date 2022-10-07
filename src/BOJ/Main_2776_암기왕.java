package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2776_암기왕 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        HashSet<Integer> set = new HashSet<>();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            set.clear();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
