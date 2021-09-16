package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1800_인터넷설치 {

    static ArrayList<Computer>[] table;
    static int N, P, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();
        int[] list;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        table = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            table[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken()) - 1;
            int com2 = Integer.parseInt(st.nextToken()) - 1;
            int pay = Integer.parseInt(st.nextToken());

            table[com1].add(new Computer(com2, pay));
            table[com2].add(new Computer(com1, pay));
            set.add(pay);
        }

        list = new int[set.size() + 1];
        int idx = 0;
        for (int i : set) {
            list[idx++] = i;
        }
        list[idx] = 0;
        Arrays.sort(list);

        int left = 0, right = list.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(list[mid])) {
                right = mid - 1;
                ans = list[mid];
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(int mid) {

        boolean[] visited = new boolean[N];
        Deque<Data> dq = new LinkedList<>();
        dq.offer(new Data(0, K));

        while (!dq.isEmpty()) {
            Data data = dq.poll();

            if (visited[data.next]) continue;

            if (data.next == N - 1) {
                return true;
            }

            visited[data.next] = true;
            for (Computer computer : table[data.next]) {
                if (visited[computer.next]) continue;

                if (computer.pay > mid) {
                    if (data.cnt > 0) {
                        dq.offerLast(new Data(computer.next, data.cnt - 1));
                    }
                }  else {
                    dq.offerFirst(new Data(computer.next, data.cnt));
                }
            }
        }

        return false;
    }

    public static class Data {
        int next, cnt;

        public Data(int next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }

    public static class Computer {
        int next, pay;

        public Computer(int next, int pay) {
            this.next = next;
            this.pay = pay;
        }
    }
}
