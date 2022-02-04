package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2220_힙정렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);
        for (int i = 2; i <= N; i++) {
            heap.add(i);
        }
        heap.arr[N - 1] = 1;

        for (int i : heap.arr) {
            sb.append(i).append(' ');
        }
        sb.append('\n');

        System.out.println(sb);
        br.close();
    }

    public static class Heap {

        int[] arr;
        int size = 0;

        public Heap(int N) {
            this.arr = new int[N];
        }

        public void add(int num) {
            arr[size] = num;
            heapify(size++);
        }

        public void heapify(int index) {
            int parent = (index - 1) >> 1;
            if (parent < 0) return;

            if (arr[index] > arr[parent]) {
                swap(index, parent);
                heapify(parent);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
