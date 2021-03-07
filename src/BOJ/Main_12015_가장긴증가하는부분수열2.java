package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2 {

    static int[] arr;
    static int idx = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int data = Integer.parseInt(st.nextToken());
            if (data > arr[idx-1]) arr[idx++] = data;
            else if (data < arr[0]) arr[0] = data;
            else binarySearch(data);
        }

        System.out.println(idx);
        br.close();
    }

    static void binarySearch(int key) {
        int mid = 0;
        int left = 0;
        int right = idx - 1;

        while(left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == key) return;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }

        if (arr[mid] < key) arr[mid+1] = key;
        else arr[mid] = key;
    }
}
