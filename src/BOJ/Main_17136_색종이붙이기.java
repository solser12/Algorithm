package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

    static boolean[][] map = new boolean[10][10];
    static int[] count = new int[5];
    static ArrayList<OneLocation> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; ++j) {
                map[i][j] = st.nextToken() == "1" ? true : false;
            }
        }

        for (int i = 0; i < 10; ++i) {
            for (int j= 0; j < 10; ++j) {
                if (map[i][j]) {
                    dfs(i, j);
                }
            }
        }
    }

    public static void dfs(int x, int y) {

    }

    public class OneLocation {
        int x, y;
        int[] list = new int[5];

        OneLocation (int x, int y, int[] list) {
            this.x = x;
            this.y = y;
            this.list = list;
        }
    }
}
