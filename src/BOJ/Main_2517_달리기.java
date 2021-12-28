package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2517_달리기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Player[] players = new Player[N];
        for (int i = 0; i < N; i++) {
            players[i] = new Player(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(players);

        int[] ans = new int[N];
        SegmentTree segmentTree = new SegmentTree(N);
        for (Player player : players) {
            ans[player.loc] = segmentTree.check(player);
        }

        for (int i : ans) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class SegmentTree {

        int size;
        int[] tree;

        public SegmentTree(int N) {
            this.size = N - 1;
            int bit = 1;
            while (bit < N) bit <<= 1;
            tree = new int[bit * 2 - 1];
        }

        public int check(Player player) {
            int result = sum(0, size, 0, 0, player.loc - 1);
            update(0, size, 0, player.loc);
            return result + 1;
        }

        public void update(int start, int end, int node, int loc) {
            if (start > loc || loc > end) return;
            tree[node]++;
            if (start == end) return;
            int mid = (start + end) >> 1;
            update(start, mid, node * 2 + 1, loc);
            update(mid + 1, end, node * 2 + 2, loc);
        }

        public int sum(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return sum(start, mid, node * 2 + 1, left , right)
                    + sum(mid + 1, end, node * 2 + 2, left, right);
        }
    }

    public static class Player implements Comparable<Player> {
        int speed, loc;

        public Player(int speed, int loc) {
            this.speed = speed;
            this.loc = loc;
        }

        @Override
        public int compareTo(Player o) {
            return o.speed - this.speed;
        }
    }
}
