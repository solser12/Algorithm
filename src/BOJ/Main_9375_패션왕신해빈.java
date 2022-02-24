package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> clothes = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if (!clothes.containsKey(type)) {
                    clothes.put(type, 1);
                } else {
                    clothes.put(type, clothes.get(type) + 1);
                }
            }

            int sum = 1;
            for (int value : clothes.values()) {
                sum *= value + 1;
            }
            sb.append(sum - 1).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
