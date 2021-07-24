package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_12852_1로만들기2 {

    static int N;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N + 1];

        bfs();

        br.close();
    }

    public static void bfs() {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = -1;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int num = q.poll();
                if (num == N) {
                    System.out.println(time);
                    print();
                    return;
                }

                int temp;
                for (int i = 0; i < 3; i++) {
                    temp = calc(num, i);
                    if (temp <= N && visited[temp] == 0) {
                        q.add(temp);
                        visited[temp] = num;
                    }
                }
            }
            time++;
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        int num = N;
        do {
            sb.append(num).append(' ');
            num = visited[num];
        } while (num != -1);

        System.out.println(sb);
    }

    public static int calc(int num, int type) {
        int result = num;

        switch (type) {
            case 0:
                result += 1;
                break;
            case 1:
                result *= 2;
                break;
            case 2:
                result *= 3;
                break;
        }

        return result;
    }
}
