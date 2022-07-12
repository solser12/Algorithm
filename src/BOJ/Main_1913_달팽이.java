package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1913_달팽이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int ansX = 0, ansY = 0;

        int[][] table = new int[n][n];
        Loc loc = new Loc(n);

        for (int i = 1; i <= n * n; i++) {
            table[loc.x][loc.y] = i;

            if (target == i) {
                ansX = loc.x + 1;
                ansY = loc.y + 1;
            }

            loc.move();
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : table) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        sb.append(ansX).append(' ').append(ansY);

        System.out.println(sb);
        br.close();
    }

    public static class Loc {
        int x, y;
        int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int index = 0, moveCnt = 0, totalMoveCnt = 1, addCnt = 0;

        public Loc(int n) {
            this.x = n / 2;
            this.y = n / 2;
        }

        public void move() {
            x += dt[index][0];
            y += dt[index][1];
            moveCnt++;

            if (moveCnt == totalMoveCnt) {
                index = (index + 1) % 4;
                moveCnt = 0;
                if (addCnt == 1) {
                    totalMoveCnt++;
                    addCnt = 0;
                } else {
                    addCnt++;
                }
            }
        }
    }
}
