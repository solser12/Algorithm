package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1427_소트인사이드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        Integer[] arr = new Integer[n.length()];
        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
        }
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        for (int i : arr) {
            sb.append(i);
        }

        System.out.println(sb);
        br.close();
    }
}