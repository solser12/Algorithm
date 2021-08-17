package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {

    static String ans = "OK";
    static int A, B, N, M;
    static int[][] map;
    static Robot[] robots;
    static int[][] dt = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean issue = false;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        map = new int[A][B];

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        robots = new Robot[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int way = change(st.nextToken().charAt(0));
            map[x][y] = i;
            robots[i] = new Robot(i, x, y, way);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (!issue) {
                int num = Integer.parseInt(st.nextToken());
                char order = st.nextToken().charAt(0);
                int cnt = Integer.parseInt(st.nextToken());

                if (!robots[num].order(order, cnt)) {
                    issue = true;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Robot {
        int num, x, y, way;

        public Robot(int num, int x, int y, int way) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.way = way;
        }

        public boolean order(char order, int cnt) {
            if (order == 'F') {

                map[this.x][this.y] = 0;
                for (int i = 0; i < cnt; i++) {
                    x += dt[way][0];
                    y += dt[way][1];

                    // 벽을 넘었는지 확인
                    if (x < 0 || x >= A || y < 0 || y >= B) {
                        ans = "Robot " + num + " crashes into the wall";
                        return false;
                    }

                    if (map[x][y] != 0 && map[x][y] != num) {
                        ans = "Robot " + num + " crashes into robot " + map[x][y];
                        return false;
                    }
                }

                map[x][y] = num;

            } else {
                if (order == 'R') {
                    if (way < cnt) {
                        way += 4 * (cnt / 4 + 1);
                    }
                    way = (way - cnt) % 4;
                } else {
                    way = (way + cnt) % 4;
                }
            }

            return true;
        }
    }

    public static int change(char way) {
        int result;

        switch (way) {
            case 'W' :
                result = 3;
                break;
            case 'E' :
                result = 1;
                break;
            case 'N' :
                result = 2;
                break;
            default:
                result = 0;
        }

        return result;
    }
}
