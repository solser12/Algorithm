package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12096_2048hard {

    static int N;
    static int max = 0, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                board[i][j] = input;
                max += input;
                ans = Math.max(ans, input);
            }
        }

        // max값 2진수 형태로 변경
        int bit = 2;
        while(true) {
            if (max < bit) {
                max = bit >> 1;
                break;
            }
            else bit <<= 1;
        }
//        int[][] temp = turn(2, board);
//        for(int[] a : temp) System.out.println(Arrays.toString(a));
//        push(temp);
//        for(int[] a : temp) System.out.println(Arrays.toString(a));
//        temp = turn(2, temp);
//        for(int[] a : temp) System.out.println(Arrays.toString(a));
        start(0, board);

        System.out.println(ans);
        br.close();
    }

    static void start(int cnt, int[][] tboard) {
        // 최대 5번 이동 헸을 때
        if (cnt == 10 || ans == max) {
//            System.out.println("ENDENDENDENDENDENDEND");
            return;
        }
        for (int i = 0; i < 4; i++) {
            // 회전하기
            int[][] temp = turn(i, tboard);
            // 밀기
            if (push(temp)) {
                // 돌려놓기
                if (i == 0) temp = turn(0, temp);
                else if (i == 1) temp = turn(3, temp);
                else if (i == 2) temp = turn(2, temp);
                else temp = turn(1, temp);
            }
            else continue;
//            System.out.println(cnt + "=============== " + (i == 0 ? "^" : (i == 1 ? "<" : (i == 2 ? "V" : ">"))));
//            for (int[] a : temp) {
//                for (int b : a) {
//                    System.out.print(b + "\t");
//                }
//                System.out.println();
//            }
            start(cnt+1, temp);
        }
    }

    // 회전하기
    static int[][] turn(int t, int[][] tboard) {
        int[][] temp = new int[N][N];

        if (t == 0) {              // 그대로
            for (int i = 0; i < N; i++) {
                temp[i] = tboard[i].clone();
            }
        }
        else if (t == 1) {        // 90도 회전
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[j][N-i-1] = tboard[i][j];
                }
            }
        }
        else if (t == 2) {        // 180도 회전
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[N-i-1][N-j-1] = tboard[i][j];
                }
            }
        }
        else if (t == 3) {        // 270도 회전
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[N-j-1][i] = tboard[i][j];
                }
            }
        }
        return temp;
    }

    // 밀기
    static boolean push(int[][] temp) {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            Queue<Loc> q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (temp[j][i] == 0) continue;
                q.add(new Loc(j, temp[j][i]));
            }
            Loc point = null;
            int loc = 0;
            while(!q.isEmpty()) {
                Loc check;
                if (point == null) {
                    point = q.poll();
                    if (q.isEmpty()) {
//                        System.out.println("큐 없음");
                        temp[loc++][i] = point.value;
                        if (point.x != loc-1) flag = true;
                        break;
                    }
                    else check = q.poll();
                }
                else {
                    check = q.poll();
                }
                if (point == check) {
//                    System.out.println("같음");
                    point.value <<= 1;
                    temp[loc++][i] = point.value;
                    ans = Math.max(point.value, ans);
                    System.out.println(max + " : " + ans);
                    if (max == ans) break;
                    point = null;
                    flag = true;
                }
                else {
//                    System.out.println("다름");
                    temp[loc++][i] = point.value;
                    if (point.x != loc-1) flag = true;
                    point = check;
                    if (q.isEmpty()) {
                        temp[loc++][i] = point.value;
                        if (point.x != loc-1) flag = true;
                    }
                }
            }
            for (int j = loc; j < N; j++) {
                temp[j][i] = 0;
            }
        }
        return flag;
    }

    static class Loc {
        int x, value;

        public Loc(int x, int value) {
            this.x = x;
            this.value = value;
        }
    }
}