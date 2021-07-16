package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9019_DSLR {

    static char[] order = {'D', 'S', 'L', 'R'};
    static char[] log = new char[10000];
    static int[] visited = new int[10000];
    static int A, B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bfs();
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs() {

        Arrays.fill(log, 'N');
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visited[A] = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int num = q.poll();

            if (num == B) {
                print();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int d = dslr(num, i);
                if (visited[d] == -1) {
                    visited[d] = num;
                    log[d] = order[i];
                    q.add(d);
                }
            }
        }
    }

    public static void print() {

        StringBuilder result = new StringBuilder();
        int temp = B;

        while (temp != A) {
            result.append(log[temp]);
            temp = visited[temp];
        }

        sb.append(result.reverse()).append('\n');
    }

    public static int dslr(int num, int command) {

        int result = 0;

        switch (command) {
            case 0 :    // D
                result = (num * 2) % 10000;
                break;
            case 1 :    // S
                result = num - 1;
                if (result < 0) result = 9999;
                break;
            case 2:     // L
                result = leftShift(num);
                break;
            case 3:     // R
                result = rightShift(num);
                break;
        }

        return result;
    }

    public static int leftShift(int num) {

        int result = 0;
        int data = num, temp, div = 1000;

        for (int i = 0; i < 4; i++) {
            temp = data / div;
            data -= temp * div;
            if (temp > 0) {
                if (i == 0) {
                    result += temp;
                } else {
                    result += temp * div * 10;
                }
            }

            div /= 10;
        }

        return result;
    }

    public static int rightShift(int num) {

        int result = 0;
        int data = num, temp, div = 1000;

        for (int i = 0; i < 4; i++) {
            temp = data / div;
            data -= temp * div;
            if (temp > 0) {
                if (i == 3) {
                    result += temp * 1000;
                } else {
                    result += temp * (div / 10);
                }
            }

            div /= 10;
        }

        return result;
    }
}
