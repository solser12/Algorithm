package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2075_N번째큰수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heap.addFirst(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                heap.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(heap.getResult());
        br.close();
    }

    public static class Heap {
        int[] arr;
        int index;

        public Heap(int N) {
            arr = new int[N + 1];
            index = 0;
        }

        public void addFirst(int num) {
            arr[index] = num;
            endHeapify(index);
            index++;
        }

        public void add(int num) {
            if (arr[0] < num) {
                arr[0] = num;
                rootHeapify(0);
            }
        }

        public int getResult() {
            return arr[0];
        }

        public void endHeapify(int idx) {
            int temp = (idx - 1) >> 1;
            if (temp < 0) return;

            if (arr[temp] > arr[idx]) {
                swap(idx, temp);
                endHeapify(temp);
            }
        }

        public void rootHeapify(int idx) {
            int p = idx;
            int l = (idx << 1) + 1;
            int r = (idx << 1) + 2;

            if (l < index && arr[l] < arr[p]) {
                p = l;
            }
            if (r < index && arr[r] < arr[p]) {
                p = r;
            }

            if (p != idx) {
                swap(idx, p);
                rootHeapify(p);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
