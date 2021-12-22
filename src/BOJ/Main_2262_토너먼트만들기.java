package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2262_토너먼트만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Tournament tournament = new Tournament(n);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tournament.insert(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n - 1; i++) {
            tournament.match();
        }

        System.out.println(tournament.sum);
        br.close();
    }

    public static class Tournament {
        int sum, index = 0;
        Player[] players;
        PriorityQueue<Player> pq = new PriorityQueue<>();

        public Tournament(int n) {
            players = new Player[n];
            sum = 0;
        }

        public void insert(int rank) {
            Player player = new Player(rank);
            players[index] = player;

            if (index != 0) {
                player.left = players[index - 1];
                players[index - 1].right = player;
            }

            pq.offer(player);
            index++;
        }

        public void match() {
            Player delPlayer = pq.poll();
            Player tempPlayer = null;

            if (delPlayer.left != null) {
                tempPlayer = delPlayer.left;
                delPlayer.left.right = delPlayer.right;
            }

            if (delPlayer.right != null) {
                delPlayer.right.left = delPlayer.left;
                if (tempPlayer == null || delPlayer.right.rank > tempPlayer.rank) {
                    tempPlayer = delPlayer.right;
                }
            }

            sum += delPlayer.rank - tempPlayer.rank;
        }
    }

    public static class Player implements Comparable<Player> {
        int rank;
        Player left, right;

        public Player(int rank) {
            this.rank = rank;
        }

        @Override
        public int compareTo(Player o) {
            return o.rank - this.rank;
        }
    }
}
