package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1092_배 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] crane = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane);

        int M = Integer.parseInt(br.readLine());;
        Stack stack = new Stack(M);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stack.arr);

        int time = 0;
        if (stack.peek() > crane[N - 1]) {
            time = -1;
        } else {
            Stack temp = new Stack(M);
            while (!stack.isEmpty()) {
                for (int i = N - 1; i >= 0; i--) {
                    int box;
                    while (!stack.isEmpty() && (box = stack.pop()) > crane[i]) {
                        temp.push(box);
                    }
                }

                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                time++;
            }
        }

        System.out.println(time);
        br.close();
    }

    public static class Stack {
        int[] arr;
        int index;

        public Stack(int M) {
            arr = new int[M];
            index = 0;
        }

        public void push(int num) {
            arr[index++] = num;
        }

        public int pop() {
            return arr[--index];
        }

        public int peek() {
            return arr[index - 1];
        }

        public boolean isEmpty() {
            return index == 0;
        }
    }
}
