package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {

    static int N, M, K, R, C;
    static int time;
    static int[][] map;
    static PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
    static int[][] dir = {{1, -1, 0, 0},{0, 0, 1, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            pq.clear();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            R = N + (K/2)*2;
            C = M + (K/2)*2;
            map = new int[R][C];
            time = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i+K/2][j+K/2] = input;
                    if (input != 0) {
                        pq.add(new Cell(new Loc(i+K/2, j+K/2), input, input, input*2-1));
                    }
                }
            }

            for (time = 0; time < K; time++) {
                int size = pq.size();
                for (int s = 0; s < size; s++) {
                    Cell cell = pq.poll();
                    // 만약 제일 빠른 세포가 현재 시간보다 느리면 시간 진행
                    if (cell.start > time) {
                        pq.add(cell);
                        break;
                    }
                    division(cell);
                }
//                System.out.println((time+1) + " ======================");
//                for (int a = 0; a < R; a++) {
//                    for (int b = 0; b < C; b++) {
//                        System.out.print(map[a][b] + "\t");
//                    }
//                    System.out.println();
//                }
            }

            sb.append('#').append(t).append(' ').append(pq.size()).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void division(Cell cell) {
        for (int d = 0; d < 4; d++) {
            int dx = cell.loc.x + dir[0][d];
            int dy = cell.loc.y + dir[1][d];
            if (map[dx][dy] != 0) continue;
            map[dx][dy] = cell.power;
            pq.add(new Cell(new Loc(dx, dy), cell.power, cell.power + time + 1, (cell.power * 2) + time));
        }
        cell.start++;
        if (cell.end > time) pq.add(cell);
    }

    static class Cell implements Comparable<Cell> {
        Loc loc;
        int power, start, end;

        public Cell(Loc loc, int power, int start, int end) {
            this.loc = loc;
            this.power = power;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "loc=" + loc +
                    ", power=" + power +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Cell o) {
            if (this.start == o.start) return o.power - this.power;
            return this.start - o.start;
        }
    }

    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}