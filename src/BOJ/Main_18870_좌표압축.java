package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] temp = new int[N];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            temp[i] = num;
            set.add(num);
        }

        int[] arr = new int[set.size()];
        int index = 0;
        for (int i : set) {
            arr[index++] = i;
        }
        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i : temp) {
            sb.append(map.get(i)).append(' ');
        }
        sb.append('\n');

        System.out.println(sb);
        br.close();
    }
}
