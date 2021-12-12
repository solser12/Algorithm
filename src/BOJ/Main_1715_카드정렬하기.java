package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1715_카드정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        for (int i = 0; i < N; i++) {
            heap.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (heap.size() > 1) {
            int temp = heap.poll() + heap.poll();
            ans += temp;
            heap.add(temp);
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

        public int size() {
            return size;
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

            if (l < size && arr[l] < arr[p]) {
                p = l;
            }
            if (r < size && arr[r] < arr[p]) {
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

            if (arr[index] < arr[parent]) {
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