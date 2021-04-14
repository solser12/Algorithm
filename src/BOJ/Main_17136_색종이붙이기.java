package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

    static int size = 10;
    static int cnt = 0, ans = Integer.MAX_VALUE;
    static int[][] paper = new int[size][size];
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 1) {
                    cnt++;
                }
            }
        }

        start(0, 0, 0);

        System.out.println(ans  == Integer.MAX_VALUE ? -1 : ans);

        br.close();
    }

    static void start(int a, int b, int num) {
//        System.out.println();
//        System.out.println("num=" + num + " / cnt=" +  cnt +  " / " + Arrays.toString(colorPaper));
//        for (int[] q : paper) {
//            for (int w : q) {
//                System.out.print(w + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if (cnt == 0) {
            ans = Math.min(ans, num);
            return;
        }
        for (int i = a; i < size; i++) {
            for (int j = a == i ? b : 0; j < size; j++) {
                if (paper[i][j] != 1) continue;
                for (int k = 1; k <= 5; k++) {
                    if (colorPaper[k] == 0) continue;
                    // 색종이 가능 부착 여부 확인
                    if (check(i, j, k)) {
                        // 부착 후 다음 단계로 넘기기
                        colorPaper[k]--;
                        start(i, j, num + 1);
                        // 부착한 거 제거하기
                        colorPaper[k]++;
                        takeoff(i, j, k);
                    }
                }
                return;
            }
        }
    }

    static void takeoff(int a, int b, int type) {
        for (int i = a; i < a + type; i++) {
            for (int j = b; j < b + type; j++) {
                paper[i][j] = 1;
            }
        }
        cnt += type * type;
    }

    static boolean check(int a, int b, int type) {
        if (a + type > size || b + type > size) return false;

        int[][] tempPaper = new int[size][];
        for (int i = 0; i < size; i++) {
            tempPaper[i] = paper[i].clone();
        }

        for (int i = a; i < a + type; i++) {
            for (int j = b; j < b + type; j++) {
                if (paper[i][j] != 1) return false;
                tempPaper[i][j] = -1;
            }
        }

        for (int i = 0; i < size; i++) {
            paper[i] = tempPaper[i].clone();
        }
        cnt -= type * type;

        return true;
    }
}
