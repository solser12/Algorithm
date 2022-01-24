package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1655_가운데를말해요 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MaxHeap maxHeap = new MaxHeap(N / 2 + 1);
        MinHeap minHeap = new MinHeap(N / 2 + 1);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) maxHeap.add(num);
            else minHeap.add(num);

            if (minHeap.size > 0 && maxHeap.peek() > minHeap.peek()) {
                int maxToMin = maxHeap.poll();
                int minToMax = minHeap.poll();
                maxHeap.add(minToMax);
                minHeap.add(maxToMin);
            }
            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class MaxHeap {
        int[] arr;
        int size;

        public MaxHeap(int len) {
            this.arr = new int[len];
            this.size = 0;
        }

        public void add(int num) {
            arr[size] = num;
            addHeapfiy(size++);
        }

        public int poll() {
            int result = arr[0];
            arr[0] = arr[--size];
            pollHeapfiy(0);
            return result;
        }

        public int peek() {
            return arr[0];
        }

        public void pollHeapfiy(int index) {
            int p = index;
            int l = (index << 1) + 1;
            int r = (index << 1) + 2;

            if (l < size && arr[p] < arr[l]) {
                p = l;
            }

            if (r < size && arr[p] < arr[r]) {
                p = r;
            }

            if (p != index) {
                swap(index, p);
                pollHeapfiy(p);
            }
        }

        public void addHeapfiy(int index) {
            int parent = (index - 1) >> 1;
            if (parent < 0) return;

            if (arr[parent] < arr[index]) {
                swap(index, parent);
                addHeapfiy(parent);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static class MinHeap {
        int[] arr;
        int size;

        public MinHeap(int len) {
            this.arr = new int[len];
            this.size = 0;
        }

        public void add(int num) {
            arr[size] = num;
            addHeapfiy(size++);
        }

        public int poll() {
            int result = arr[0];
            arr[0] = arr[--size];
            pollHeapfiy(0);
            return result;
        }

        public int peek() {
            return arr[0];
        }

        public void pollHeapfiy(int index) {
            int p = index;
            int l = (index << 1) + 1;
            int r = (index << 1) + 2;

            if (l < size && arr[p] > arr[l]) {
                p = l;
            }

            if (r < size && arr[p] > arr[r]) {
                p = r;
            }

            if (p != index) {
                swap(index, p);
                pollHeapfiy(p);
            }
        }

        public void addHeapfiy(int index) {
            int parent = (index - 1) >> 1;
            if (parent < 0) return;

            if (arr[parent] > arr[index]) {
                swap(index, parent);
                addHeapfiy(parent);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
