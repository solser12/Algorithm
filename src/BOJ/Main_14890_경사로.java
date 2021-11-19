package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack row = new Stack(N);
        Stack column = new Stack(N);

        for (int i = 0; i < N; i++) {
            row.push(new Road(map[i][0], 1));
            column.push(new Road(map[0][i], 1));
            for (int j = 1; j < N; j++) {
                Road road = row.peek();
                if (road.height == map[i][j]) road.add();
                else row.push(new Road(map[i][j], 1));

                road = column.peek();
                if (road.height == map[j][i]) road.add();
                else column.push(new Road(map[j][i], 1));
            }

            if (check(row, L)) ans++;
            if (check(column, L)) ans++;

            row.clear();
            column.clear();
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean check(Stack stack, int L) {
        while (stack.size() > 1) {
            Road first = stack.pop();
            Road second = stack.peek();

            if (first.height > second.height) {
                if (second.count < L || first.height - second.height > 1) {
                    return false;
                } else {
                    second.count -= L;
                }
            } else {
                if (first.count < L || second.height - first.height > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static class Stack {
        Road[] arr;
        int index;

        public Stack(int size) {
            this.arr = new Road[size];
            this.index = 0;
        }

        public void push(Road road) {
            arr[index++] = road;
        }

        public Road pop() {
            return arr[--index];
        }

        public Road peek() {
            return arr[index - 1];
        }

        public void clear() {
            index = 0;
        }

        public int size() {
            return index;
        }
    }

    public static class Road {
        int height, count;

        public Road(int height, int count) {
            this.height = height;
            this.count = count;
        }

        public void add() { count++; }

    }
}
