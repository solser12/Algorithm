package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2800_괄호제거 {

    static char[] input;
    static ArrayList<bracket> brackets = new ArrayList<>();
    static TreeSet<String> set = new TreeSet<>();
    static boolean[] visited;
    static boolean isFirst = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                brackets.add(new bracket(stack.pop(), i));
            }
        }
        visited = new boolean[input.length];
        Arrays.fill(visited, true);
        find(0);

        for (String s : set) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void find(int depth) {

        if (depth == brackets.size()) {
            if (isFirst) {
                isFirst = false;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < input.length; i++) {
                    if (visited[i]) {
                        sb.append(input[i]);
                    }
                }
                set.add(sb.toString());
            }
            return;
        }

        bracket bracket = brackets.get(depth);
        visited[bracket.start] = true;
        visited[bracket.end] = true;
        find(depth + 1);

        visited[bracket.start] = false;
        visited[bracket.end] = false;
        find(depth + 1);
    }

    public static class bracket {
        int start, end;

        public bracket(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
