package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2412_암벽등반 {

    static int n, T;
    static ArrayList<Integer>[] rock;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        rock = new ArrayList[200001];
        for (int i = 0; i < 200001; i++) {
            rock[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            rock[y].add(x);
        }

        for (int i = 0; i < 200001; i++) {
            Collections.sort(rock[i]);
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {

        Queue<Loc> q = new LinkedList<>();
        q.offer(new Loc(0, 0));

        int move = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Loc loc = q.poll();
                if (loc.y == T) return move;
                for (int y = loc.y - 2; y <= loc.y + 2; y++) {
                    if (y < 0 || y >= 200001) continue;
                    for (int j = 0; j < rock[y].size(); j++) {
                        int x = rock[y].get(j);
                        if (loc.x + 2 < x) break;
                        else if (loc.x - 2 > x) continue;

                        rock[y].remove(j);
                        q.add(new Loc(x, y));
                        j--;
                    }
                }
            }
            move++;
        }

        return -1;
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
