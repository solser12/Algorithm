package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1202_보석_도둑 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        int[] bags = new int[K];
        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bags);

        long ans = 0;
        int index = 0;
        for (int bag : bags) {
            while (index < N && jewels[index][0] <= bag) {
                heap.add(jewels[index++][1]);
            }

            if (!heap.isEmpty()) {
                ans += heap.poll();
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static class Heap {
        int size;
        int[] arr;

        public Heap(int N) {
            this.arr = new int[N];
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(int num) {
            arr[size] = num;
            addHeapify(size++);
        }

        public int poll() {
            int result = arr[0];
            arr[0] = arr[--size];
            pollHeapify(0);
            return result;
        }

        public void pollHeapify(int index) {
            int p = index;
            int l = (index << 1) + 1;
            int r = (index << 1) + 2;

            if (l < size && arr[l] > arr[p]) {
                p = l;
            }
            if (r < size && arr[r] > arr[p]) {
                p = r;
            }

            if (p != index) {
                swap(index, p);
                pollHeapify(p);
            }
        }

        public void addHeapify(int index) {
            int parent = (index - 1) >> 1;
            if (parent < 0) return;

            if (arr[index] > arr[parent]) {
                swap(index, parent);
                addHeapify(parent);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
