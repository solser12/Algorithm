package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_1071_소트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        HashMap<Integer, Integer> intToIndex = new HashMap<>();
        int[] arr = new int[map.size()];
        int index = 0;
        for (int i : map.keySet()) {
            intToIndex.put(i, index);
            arr[index++] = i;
        }

        while (!map.isEmpty()) {
            int num = map.firstKey();

            if (map.containsKey(num + 1)) {
                boolean find = false;
                for (int i = intToIndex.get(num + 1) + 1; i < arr.length; i++) {
                    if (arr[i] == -1) continue;
                    printAll(sb, map, num, intToIndex.get(num), arr);
                    sb.append(arr[i]).append(' ');
                    int cnt = map.get(arr[i]);
                    if (cnt > 1) {
                        map.put(arr[i], map.get(arr[i]) - 1);
                    } else {
                        map.remove(arr[i]);
                    }
                    find = true;
                    break;
                }

                if (!find) {
                    printAll(sb, map, num + 1, intToIndex.get(num + 1), arr);
                    printAll(sb, map, num, intToIndex.get(num), arr);
                }
            } else {
                printAll(sb, map, num, intToIndex.get(num), arr);
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    public static void printAll(StringBuilder sb, TreeMap<Integer, Integer> map, int num, int index, int[] arr) {
        for (int i = 0; i < map.get(num); i++) {
            sb.append(num).append(' ');
        }
        map.remove(num);
        arr[index] = -1;
    }
}
