package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16637_괄호추가하기 {

    static int N, ans = Integer.MIN_VALUE;
    static char[] arr;
    static boolean[] visited;
    static Queue<Integer> number = new LinkedList<>();
    static Queue<Character> operator = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = br.readLine().toCharArray();
        visited = new boolean[N/2];

        if (N != 1) check(0);
        else ans = arr[0] - '0';

        System.out.println(ans);
        br.close();
    }

    static void check(int depth) {

        if (depth >= N/2) {
            // 연산 시작
            calculate();
            return;
        }

        check(depth + 1);
        visited[depth] = true;
        check(depth + 2);
        visited[depth] = false;
    }

    static void calculate() {

        number.clear();
        operator.clear();
        operator.add('+');

        for (int i = 0; i < N / 2; i++) {
            if (visited[i]) {
                number.add(result(arr[i * 2] - '0', arr[i * 2 + 2] - '0', arr[i * 2 + 1]));
            } else {
                if (i > 0 && !visited[i - 1]) {
                    number.add(arr[i * 2] - '0');
                } else if (i == 0) {
                    number.add(arr[i * 2] - '0');
                }
                operator.add(arr[i * 2 + 1]);
                if (i == N / 2 - 1) number.add(arr[i * 2 + 2] - '0');
            }
        }

        int calc = 0;
        while (!number.isEmpty()) {
            int num = number.poll();
            Character oper = operator.poll();
            calc = result(calc, num, oper);
        }

        ans = Math.max(ans, calc);
    }

    static int result(int num1, int num2, char oper) {
        if (oper == '+') return num1 + num2;
        else if (oper == '-') return num1 - num2;
        else return num1 * num2;
    }
}
