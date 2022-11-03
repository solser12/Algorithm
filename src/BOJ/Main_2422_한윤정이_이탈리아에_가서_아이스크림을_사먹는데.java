package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2422_한윤정이_이탈리아에_가서_아이스크림을_사먹는데 {

    public static int N, M;
    public static HashSet<Integer>[] badMix;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        badMix = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            badMix[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            badMix[a].add(b);
            badMix[b].add(a);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                for (int k = j + 1; k <= N; k++) {
                    if (!check(i, j, k)) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(int a, int b, int c) {
        return badMix[a].contains(b) || badMix[a].contains(c) || badMix[b].contains(c);
    }
}
