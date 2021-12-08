package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1517_버블소트 {

    public static int N;
    public static int[] arr;
    public static long ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, arr.length - 1);

        System.out.println(ans);
        br.close();
    }

    public static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public static void merge(int left, int mid, int  right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int index = left, leftIdx = 0, rightIdx = 0, cnt = leftArr.length;

        while (leftIdx < leftArr.length && rightIdx < rightArr.length) {
            if (leftArr[leftIdx] > rightArr[rightIdx]) {
                arr[index] = rightArr[rightIdx++];
                ans += cnt;
            } else {
                arr[index] = leftArr[leftIdx++];
                cnt--;
            }
            index++;
        }

        while (rightIdx < rightArr.length) {
            arr[index++] = rightArr[rightIdx++];
        }
        while (leftIdx < leftArr.length) {
            arr[index++] = leftArr[leftIdx++];
        }
    }
}
