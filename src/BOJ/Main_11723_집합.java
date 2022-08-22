package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Program program = new Program();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                program.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("remove")) {
                program.remove(Integer.parseInt(st.nextToken()));
            } else if (order.equals("check")) {
                sb.append(program.check(Integer.parseInt(st.nextToken()))).append('\n');
            } else if (order.equals("toggle")) {
                program.toggle(Integer.parseInt(st.nextToken()));
            } else if (order.equals("all")) {
                program.all();
            } else {
                program.empty();
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Program {

        int bitmask = 0;

        public void add(int num) {
            bitmask |= (1 << num);
        }

        public void remove(int num) {
            bitmask &= ~(1 << num);
        }

        public int check(int num) {
            return (bitmask & (1 << num)) > 0 ? 1 : 0;
        }

        public void toggle(int num) {
            bitmask ^= (1 << num);
        }

        public void all() {
            bitmask = (1 << 21) - 1;
        }

        public void empty() {
            bitmask = 0;
        }
    }
}
