package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_18808_스티커붙이기 {

    static int N, M, K, ans = 0;
    static int[][] notebook;
    static ArrayList<Sticker> stickers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        notebook = new int[N][M];
        
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            ArrayList<Loc> arr = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        arr.add(new Loc(i, j));
                        cnt++;
                    }
                }
            }
            stickers.add(new Sticker(arr, R, C, cnt));
        }

        for (Sticker sticker : stickers) {
            if (stick(sticker)) {
                ans += sticker.num;
            }
        }

        System.out.println(ans);
        br.close();   
    }

    public static boolean stick(Sticker sticker) {
        do {
            int R = sticker.R;
            int C = sticker.C;
            Stack<Loc> temp = new Stack<>();

            for (int i = 0; i <= N - R; i++) {
                for (int j = 0; j <= M - C; j++) {
                    int count = 0;
                    for (Loc loc : sticker.loc) {
                        int dx = i + loc.x;
                        int dy = j + loc.y;
                        if (notebook[dx][dy] == 0) {
                            count++;
                            notebook[dx][dy]++;
                            if (count == sticker.num) return true;
                            temp.push(new Loc(dx, dy));
                        } else {
                            while (!temp.isEmpty()) {
                                Loc l = temp.pop();
                                notebook[l.x][l.y] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        } while (sticker.rotate());

        return false;
    }

    public static class Sticker {
        Loc[] loc;
        int R, C, num, cnt = 0;

        public Sticker(ArrayList<Loc> arr, int r, int c, int num) {
            this.loc = arr.toArray(new Loc[0]);
            R = r;
            C = c;
            this.num = num;
        }

        public boolean rotate() {
            if (cnt >= 3) return false;

            for (Loc l : loc) {
                l.rotate(R);
            }

            int temp = R;
            R = C;
            C = temp;
            cnt++;

            return true;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void rotate(int R) {
            int temp = y;
            y = R - x - 1;
            x = temp;
        }
    }
}
