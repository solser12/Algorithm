package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_11652_카드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int maxCnt = 0;
        long maxNum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            int cnt = map.get(num);
            if (cnt > maxCnt) {
                maxNum = num;
                maxCnt = cnt;
            } else if (cnt == maxCnt && num < maxNum) {
                maxNum = num;
            }
        }

        System.out.println(maxNum);
        br.close();
    }
}
