package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11758_CCW {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr =new int[2][4];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        arr[0][3] = arr[0][0];
        arr[1][3] = arr[1][0];

        int temp1 = (arr[0][0] * arr[1][1]) + (arr[0][1] * arr[1][2]) + (arr[0][2] * arr[1][3]);
        int temp2 = (arr[0][1] * arr[1][0]) + (arr[0][2] * arr[1][1]) + (arr[0][3] * arr[1][2]);
        int result = temp1 - temp2;

        if (result > 0) System.out.println(1);
        else if (result < 0) System.out.println(-1);
        else System.out.println(0);

        br.close();
    }
}