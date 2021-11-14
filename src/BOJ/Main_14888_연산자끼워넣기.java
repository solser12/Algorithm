package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

    public static int size, maxAns = Integer.MIN_VALUE, minAns = Integer.MAX_VALUE;
    public static int[] arr, operator;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        arr = new int[size];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(maxAns);
        System.out.println(minAns);
        br.close();
    }

    public static void dfs(int depth, int sum) {

        if (depth == size) {
            maxAns = Math.max(maxAns, sum);
            minAns = Math.min(minAns, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i]--;
            dfs(depth + 1, calc(sum, arr[depth], i));
            operator[i]++;
        }
    }

    public static int calc(int a, int b, int type) {
        int result;
        if (type == 0) result = a + b;
        else if (type == 1) result = a - b;
        else if (type == 2) result = a * b;
        else result = a / b;
        return result;
    }
}
