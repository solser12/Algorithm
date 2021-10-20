package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18115_카드놓기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            deque.push(Integer.parseInt(st.nextToken()));
        }

        System.out.println(deque);
        br.close();
    }

    public static class MyDeque {
        int[] arr;
        int left, right, mid, card;

        public MyDeque(int size) {
            this.arr = new int[size];
            this.left = 0;
            this.mid = 1;
            this.right = size - 1;
            this.card = size;
        }

        public void push(int type) {
            if (type == 1) {
                arr[left] = card;
                left = mid;
                mid++;
            } else if (type == 2) {
                arr[mid++] = card;
            } else {
                arr[right--] = card;
            }
            card--;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            return sb.toString();
        }
    }
}
