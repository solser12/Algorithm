package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        char check = bomb[bomb.length - 1];

        Stack stack = new Stack(input.length);

        for (char c : input) {
            stack.push(c);
            if (c == check && stack.size() >= bomb.length) {
                stack.check(bomb);
            }
        }

        if (stack.size() == 0) {
            sb.append("FRULA");
        } else {
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.arr[i]);
            }
        }


        System.out.println(sb);
        br.close();
    }

    public static class Stack {
        char[] arr;
        int idx = 0;

        public Stack(int size) {
            arr = new char[size];
        }

        public void check(char[] bomb) {
            int bIdx = bomb.length - 1;
            for (int i = idx - 1; i >= idx - bomb.length; i--) {
                if (arr[i] != bomb[bIdx--]) return;
            }
            idx = idx - bomb.length;
        }

        public int size() {
            return idx;
        }

        public void push(char c) {
            arr[idx++] = c;
        }

        public char peek() {
            return arr[idx-1];
        }

        public char pop() {
            return arr[--idx];
        }
    }
}
