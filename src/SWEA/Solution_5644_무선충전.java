package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {

    static final int MAP_SIZE = 10;

    static User user1, user2;                   // 사용자 클래스
    static int[] batteryPower;                  // 충전소 리스트
    static int[][] map;                         // 충전소 영역을 비트마스크로 표시
    static int bCnt, result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int infoSize = Integer.parseInt(st.nextToken());
            bCnt = Integer.parseInt(st.nextToken());

            // 첫 번째 사용자 클래스 생성
            st = new StringTokenizer(br.readLine());
            int[] moveInfo = new int[infoSize];
            for (int i = 0; i < infoSize; i++) {
                moveInfo[i] = Integer.parseInt(st.nextToken());
            }
            user1 = new User(0, 0, moveInfo);

            // 두 번째 사용자 클래스 생성
            st = new StringTokenizer(br.readLine());
            moveInfo = new int[infoSize];
            for (int i = 0; i < infoSize; i++) {
                moveInfo[i] = Integer.parseInt(st.nextToken());
            }
            user2 = new User(MAP_SIZE - 1, MAP_SIZE - 1, moveInfo);


            // 충전소 초기화
            batteryPower = new int[bCnt];
            map = new int[10][10];
            for (int b = 0; b < bCnt; b++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                batteryPower[b] = power;

                int start = y, end = y;
                int top = x - range;
                for (int i = 0; i < range * 2 + 1; i++) {
                    if (top >= 0 && top < MAP_SIZE) {
                        for (int j = y; j >= start; j--) {
                            if (j < 0) break;
                            map[top][j] |= (1 << b);
                        }
                        for (int j = y; j <= end; j++) {
                            if (j >= MAP_SIZE) break;
                            map[top][j] |= (1 << b);
                        }
                    }

                    if (i < range) {
                        start--; end++;
                    }
                    else {
                        start++; end--;
                    }
                    top++;
                }
            }

            checking();
            for (int a = 0; a < infoSize; a++) {
                user1.move();
                user2.move();
                checking();
            }


            sb.append('#').append(t).append(' ').append(result).append('\n');
        }


        System.out.println(sb.toString());
        br.close();
    }

    static void checking() {
        int[] u1 = new int[bCnt];
        int[] u2 = new int[bCnt];

        for (int i = 0; i < bCnt; i++) {
            if ((map[user1.x][user1.y] & (1 << i)) != 0) {
                u1[i]++;
            }
            if ((map[user2.x][user2.y] & (1 << i)) != 0) {
                u2[i]++;
            }
        }

        int max1 = 0, max2 = 0, max = 0;
        for (int i = 0; i < bCnt; i++) {
            if (u1[i] == 1) max1 = batteryPower[i];
            for (int j = 0; j < bCnt; j++) {
                int temp;
                if (u2[j] == 1) max2 = batteryPower[j];
                temp = max1 + max2;
                if (i == j && max1 == max2) temp /= 2;
                max = Math.max(max, temp);
                max2 = 0;
            }
            max1 = 0;
        }

        result += max;
    }


    static class User {
        int x, y, idx;
        int[] moveInfo;

        public User(int x, int y, int[] moveInfo) {
            this.x = x;
            this.y = y;
            this.moveInfo = moveInfo;
            idx = 0;
        }

        public void move() {
            switch (moveInfo[idx++]) {
                case 1:
                    x--;
                    break;
                case 2:
                    y++;
                    break;
                case 3:
                    x++;
                    break;
                case 4:
                    y--;
                    break;
            }
        }
    }
}
