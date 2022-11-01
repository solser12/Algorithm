package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1331_나이트투어 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[6][6];
        Knight knight = new Knight(br.readLine());
        visited[knight.x][knight.y] = true;
        
        boolean ans = true;
        for (int i = 0; i < 35; i++) {
            if (!knight.check(br.readLine())) {
                ans = false;
                break;
            }

            if (visited[knight.x][knight.y]) {
                ans = false;
                break;
            }

            visited[knight.x][knight.y] = true;
        }

        System.out.println(ans && (knight.lastCheck()) ? "Valid" : "Invalid");
        br.close();
    }

    public static class Knight {
        int startX, startY, x, y;

        public Knight(String start) {
            this.x = start.charAt(1) - '1';
            this.y = start.charAt(0) - 'A';
            this.startX = this.x;
            this.startY = this.y;
        }
        
        public boolean check(String str) {
            int nowX = str.charAt(1) - '1';
            int nowY = str.charAt(0) - 'A';
            int tempX = Math.abs(this.x - nowX);
            int tempY = Math.abs(this.y - nowY);

            if ((tempX == 2 && tempY == 1) || (tempX == 1 && tempY == 2)) {
                this.x = nowX;
                this.y = nowY;
                return true;
            }

            return false;
        }

        public boolean lastCheck() {
            int tempX = Math.abs(x - startX);
            int tempY = Math.abs(y - startY);
            return (tempX == 2 && tempY == 1) || (tempX == 1 && tempY == 2);
        }
    }
}
