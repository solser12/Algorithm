package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1525_퍼즐 {

    static final int goal = 123456780;
    static int input = 0;
    static int[][] dt = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map = new int[3][3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
            }
        }
        input = arrToInt();

        System.out.println(bfs());

        br.close();
    }

    public static int bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(input);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(input);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int num = q.poll();

                if (num == goal) {
                    return time;
                }

                int[] result = move(num);
                for (int i : result) {
                    if (i == -1) continue;;
                    if (!visited.contains(i)) {
                        q.add(i);
                        visited.add(i);
                    }
                }
            }
            time++;
        }

        return -1;
    }

    public static int[] move(int num) {

        int idx = 0;
        int[] list = new int[4];
        Arrays.fill(list, -1);

        int mul = 100000000;
        int temp, x = 0, y = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp = num / mul;
                map[i][j] = temp;
                num -= temp * mul;
                mul /= 10;

                if (temp == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        temp = map[x][y];

        for (int d = 0; d < 4; d++) {
            int dx = x + dt[d][0];
            int dy = y + dt[d][1];

            if (dx >= 0 && dx < 3 && dy >= 0 && dy < 3) {
                map[x][y] = map[dx][dy];
                map[dx][dy] = temp;

                int result = arrToInt();
                list[idx++] = result;

                map[dx][dy] = map[x][y];
                map[x][y] = temp;
            }
        }

        return list;
    }

    public static int arrToInt() {

        int result = 0;
        int mul = 100000000;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = map[i][j];
                result += temp * mul;
                mul /= 10;
            }
        }

        return result;
    }
}
