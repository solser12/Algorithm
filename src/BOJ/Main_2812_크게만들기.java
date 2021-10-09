package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2812_크게만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        Stack stack = new Stack(N);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = input.charAt(i) - '0';

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < K) {
                    if (stack.peek() < num) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }

            stack.push(num);

            if (count == K) {
                sb.append(input.substring(i+1));
                break;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count < K) {
                count++;
                continue;
            }
            sb.insert(0, num);
        }

        System.out.println(sb);

        br.close();
    }

    public static class Stack {
        int[] arr;
        int idx;

        public Stack(int size) {
            this.arr = new int[size];
        }

        public void push(int num) {
            arr[idx++] = num;
        }

        public boolean isEmpty() {
            return idx == 0;
        }

        public int peek() {
            return arr[idx -1];
        }

        public int pop() {
            return arr[--idx];
        }
    }
}
