package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

    static int[] queue = new int[9];
    static int front, rear;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();

        int temp;
        String s;

        for (int tc = 1; tc <= 10; ++tc) {

            front = 0;
            rear = 0;

            s = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; ++i) {
                enqueue(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < 9; i++) {

            }

            for (int i = 1; ; ++i) {
                temp = dequeue();
                temp -= i;

                if (temp > 0) {
                    enqueue(temp);
                }
                else {
                    enqueue(0);
                    break;
                }

                if (i == 5) i = 0;
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 8; ++i) {
                sb.append(dequeue()).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void enqueue(int data) {
        queue[++rear] = data;
        if (rear == queue.length-1) rear = -1;
    }

    public static int dequeue() {
        int result;
        result = queue[++front];
        if (front == queue.length-1) front = -1;
        return result;
    }
}
