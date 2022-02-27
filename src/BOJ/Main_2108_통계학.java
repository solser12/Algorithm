package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main_2108_통계학 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> index = new HashMap<>();
        ArrayList<Number> numbers = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            if (!index.containsKey(num)) {
                index.put(num, index.size());
                numbers.add(new Number(num, 0));
            }
            numbers.get(index.get(num)).count();
        }
        Arrays.sort(arr);
        Collections.sort(numbers);

        sb.append(Math.round((double) sum / N)).append('\n');
        sb.append(arr[N / 2]).append('\n');

        Number number = numbers.get(0);
        int ans = number.num;
        if (numbers.size() > 1 && numbers.get(1).count == number.count) {
            ans = numbers.get(1).num;
        }
        sb.append(ans).append('\n');
        sb.append(arr[N - 1] - arr[0]).append('\n');

        System.out.println(sb);
        br.close();
    }

    public static class Number implements Comparable<Number> {
        int num, count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public void count() {
            count++;
        }

        @Override
        public int compareTo(Number o) {
            if (this.count == o.count) return this.num - o.num;
            return o.count - this.count;
        }
    }
}
