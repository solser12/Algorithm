package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {

    static int N, K, L, timer = 0;
    static int[][] map;
    static Queue<Way> schedule = new LinkedList<>();
    static Queue<Loc> tail = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char way = st.nextToken().charAt(0);
            schedule.add(new Way(time, way));
        }

        gameStart();

        System.out.println(timer);
        br.close();
    }

    static void gameStart() {

        // 뱀의 이동 방향
        Loc snakeHead = new Loc(0, 0);
        char snakeWay = 'R';

        // 꼬리 위치 저장
        tail.add(new Loc(0, 0));
        map[0][0] = -1;

        // 미리할 스케쥴 찾기
        Way way = schedule.poll();

        // 게임 시작
        while(true) {
//            System.out.println(timer + "====================");
//            for (int[] i : map) {
//                for (int j : i) {
//                    System.out.print((j == 1 ? "@" : (j == -1) ? "ㅁ" : 0) + "\t");
//                }
//                System.out.println();
//            }

            snakeHead = move(snakeHead, snakeWay);
            timer++;
            if (snakeHead == null) break;

            if (way.time == timer) {
                snakeWay = changeWay(way.way, snakeWay);
                if (!schedule.isEmpty()) way = schedule.poll();
            }
        }
    }

    // 뱀의 이동을 담당
    static Loc move(Loc head, char way) {
        int x = head.x;
        int y = head.y;

        // 이동하기
        if (way == 'R') y++;
        else if (way == 'L') y--;
        else if (way == 'U') x--;
        else x++;

        // 벽에 닿았을 때
        if (x >= N || x < 0 || y >= N || y < 0) return null;

        // 사과를 안먹으면 꼬리도 이동
        if (map[x][y] != -1 && map[x][y] != 1) {
            Loc loc = tail.poll();
            map[loc.x][loc.y] = 0;
        }

        // 뱀머리가 몸에 닿았을 때
        if (map[x][y] == -1)  return null;

        // 살아있으면
        map[x][y] = -1;
        tail.add(new Loc(x, y));
        return new Loc(x, y);
    }



    // 방향이 바뀌었을 때
    static char changeWay(char way, char snakeWay) {
        // 왼쪽으로 90도
        if (way == 'L') {
            if (snakeWay == 'R') return 'U';
            else if (snakeWay == 'L') return 'D';
            else if (snakeWay == 'U') return 'L';
            else return 'R';
        }
        // 오른쪽으로 90도
        else {
            if (snakeWay == 'R') return 'D';
            else if (snakeWay == 'L') return 'U';
            else if (snakeWay == 'U') return 'R';
            else return 'L';
        }
    }


    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Way {
        int time;
        char way;

        public Way(int time, char way) {
            this.time = time;
            this.way = way;
        }
    }
}
