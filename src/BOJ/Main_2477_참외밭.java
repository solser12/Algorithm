package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        ArrayList<Integer> side = new ArrayList<>();
        int max_w = 0;
        int max_h = 0;
        int max_i = 0;
        int max_j = 0;
        int min_w, min_h;
        int ans;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            side.add(len);

            if (way == 1 || way == 2) {
                if (max_w < len) {
                    max_w = len;
                    max_i = i;
                }
            }
            else {
                if (max_h < len) {
                    max_h = len;
                    max_j = i;
                }
            }
        }

        side.remove(Math.max(max_i, max_j));
        side.remove(Math.min(max_i, max_j));

        if (!(((max_i + max_j) == 1) || ((max_i + max_j) == 9) || (((max_i + max_j) == 5) && ((max_i == 0) || (max_j == 0))))) {
            int min = Math.min(max_i, max_j);
            for (int i = 0; i < min; i++) {
                int temp = side.get(0);
                side.remove(0);
                side.add(temp);
            }
        }

        min_w = side.get(1);
        min_h = side.get(2);

        ans = ((max_w * max_h) - (min_w * min_h)) * K;
        System.out.println(ans);
        br.close();
    }
}
