package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1963_소수경로 {

    public static HashSet<Integer> primeNumber = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ans = bfs(start, end);
            sb.append((ans == -1 ? "Impossible" : ans)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int poll = q.poll();
                if (poll == end) return cnt;

                int divNum = poll, mul = 1;
                for (int i = 0; i < 4; i++) {
                    int num = divNum % 10;
                    int change = poll - num * mul;
                    for (int j = 0; j < 10; j++) {
                        int temp = change + (j * mul);
                        if (primeNumber.contains(temp) && !visited.contains(temp)) {
                            q.add(temp);
                            visited.add(temp);
                        }
                    }
                    divNum /= 10;
                    mul *= 10;
                }
            }
            cnt++;
        }

        return -1;
    }

    public static void init() {
        boolean[] check = new boolean[10000];
        for (int i = 2; i < 10000; i++) {
            if (check[i]) continue;
            for (int j = i + i; j < 10000; j += i) {
                check[j] = true;
            }
        }

        for (int i = 1000; i < 10000; i++) {
            if (!check[i]) primeNumber.add(i);
        }
    }
}
