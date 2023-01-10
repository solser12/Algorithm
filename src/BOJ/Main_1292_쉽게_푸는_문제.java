package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292_쉽게_푸는_문제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001];
        int index = 2;
        int size = 2;

        arr[1] = 1;
        while (index != 1001) {
            for (int i = 0; i < size; i++) {
                arr[index] = arr[index - 1] + size;
                index++;
                if (index == 1001) {
                    break;
                }
            }
            size++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(arr[b] - arr[a - 1]);
        br.close();
    }
}
