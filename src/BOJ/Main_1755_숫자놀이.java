package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1755_숫자놀이 {

    public static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Number[] numbers = new Number[n - m + 1];
        for (int i = m; i <= n; i++) {
            numbers[i - m] = new Number(i);
        }
        Arrays.sort(numbers);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (Number number : numbers) {
            sb.append(number.num);
            if (count == 9) {
                sb.append('\n');
                count = 0;
            } else {
                sb.append(' ');
                count++;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void init() {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
    }

    public static class Number implements Comparable<Number> {
        int num;
        String s;

        public Number(int num) {
            this.num = num;
            this.s = numToString(num);
        }

        private String numToString(int num) {
            StringBuilder sb = new StringBuilder();
            char[] arr = String.valueOf(num).toCharArray();
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(map.get(arr[i] - '0')).append(' ');
            }
            sb.append(map.get(arr[arr.length - 1] - '0'));
            return sb.toString();
        }

        @Override
        public int compareTo(Number o) {
            return this.s.compareTo(o.s);
        }
    }
}
