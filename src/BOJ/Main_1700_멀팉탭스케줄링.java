package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1700_멀팉탭스케줄링 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> next = new ArrayList<>();
        Queue<Integer>[] order = new LinkedList[K + 1];
        for (int i = 1; i <= K; i++) order[i] = new LinkedList<>();
        HashSet<Integer> use = new HashSet<>();

        int useCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int data = Integer.parseInt(st.nextToken());
            if (useCnt == N) {
                order[data].add(i);
                next.add(data);
            } else {
                if (!use.contains(data)) {
                    use.add(data);
                    useCnt++;
                }
            }
        }

        int ans = 0;
        for (int i : next) {
            // 뺄 콘센트 정하기
            // 1. 이미 꽂혀있는 콘센트인지 확인
            if (use.contains(i)) {
                order[i].poll();
                continue;
            }

            // 2. 앞으로 사용을 안하거나 나중에 사용될 콘센트 찾기
            int out = 0;
            int min = Integer.MIN_VALUE;
            for (int u : use) {
                if (order[u].size() == 0) {
                    out = u;
                    break;
                } else {
                    int peek = order[u].peek();
                    if (peek > min) {
                        out = u;
                        min = peek;
                    }
                }
            }

            use.remove(out);
            use.add(i);
            order[i].poll();

            ans++;
        }

        System.out.println(ans);
        br.close();
    }
}
