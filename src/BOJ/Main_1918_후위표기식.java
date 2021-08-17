package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main_1918_후위표기식 {

    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        String infix = br.readLine();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                // 문자인 경우
                sb.append(c);
            } else if (c == ')') {
                // 닫는 괄호인 경우
                while (true) {
                    char temp = s.pop();
                    if (temp == '(') {
                        break;
                    }
                    sb.append(temp);
                }
            } else {
                if (s.isEmpty()) {
                    s.push(c);
                    continue;
                }

                // 연산자인 경우
                if (c == '(') {
                    s.push(c);
                } else {
                    boolean empty = true;
                    while (!s.isEmpty()) {
                        char temp = s.peek();
                        if (check(c, temp)) {
                            sb.append(s.pop());
                        } else {
                            s.push(c);
                            empty = false;
                            break;
                        }
                    }

                    if (empty) s.push(c);
                }
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean check(char a, char b) {
        int ca = map.get(a);
        int cb = map.get(b);

        if (cb == 3) return false;

        if (ca <= cb) {
            return true;
        }

        return false;
    }
}