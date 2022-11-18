package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_14646_욱제는_결정장애야 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!set.contains(num)) {
                set.add(num);
                ans = Math.max(ans, set.size());
            } else {
                set.remove(num);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
