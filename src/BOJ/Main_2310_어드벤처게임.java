package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2310_어드벤처게임 {

    static int n;
    static Room[] room;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while ((n = Integer.parseInt(br.readLine())) != 0) {

            room = new Room[n+1];
            visited = new boolean[n+1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);
                int pay = Integer.parseInt(st.nextToken());

                room[i] = new Room(type, pay);

                int next = Integer.parseInt(st.nextToken());
                while (next != 0) {
                    room[i].append(next);
                    next = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(dfs(1, 0) ? "Yes" : "No").append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean dfs(int num, int gold) {

        int nextGold = gold;
        Room r = room[num];

        if (r.type == 'L') {
            nextGold = Math.max(gold, r.pay);
        } else if (r.type == 'T') {
            nextGold = gold - r.pay;
            if (nextGold < 0) return false;
        }

        if (num == n) {
            return true;
        }

        for (int i : r.next) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dfs(i, nextGold)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public static class Room {
        char type;
        int pay;
        ArrayList<Integer> next = new ArrayList<>();

        public Room(char type, int pay) {
            this.type = type;
            this.pay = pay;
        }

        public void append(int i) {
            next.add(i);
        }
    }
}