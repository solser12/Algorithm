package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2910_빈도정렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Number> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, new Number(num, 1, map.size()));
            } else {
                Number temp = map.get(num);
                temp.addCnt();
                map.put(num, temp);
            }
        }

        Number[] arr = new Number[map.size()];
        int index = 0;
        for (Number num : map.values()) {
            arr[index++] = num;
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (Number number : arr) {
            sb.append(number.toString());
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    public static class Number implements Comparable<Number> {
        int num, cnt, order;

        public Number(int num, int cnt, int order) {
            this.num = num;
            this.cnt = cnt;
            this.order = order;
        }

        public void addCnt() {
            this.cnt++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                sb.append(num).append(' ');
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Number o) {
            if (this.cnt == o.cnt) {
                return this.order - o.order;
            }
            return o.cnt - this.cnt;
        }
    }
}
