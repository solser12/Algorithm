package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1302_베스트셀러 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            if (map.containsKey(title)) {
                map.put(title, map.get(title) + 1);
            } else {
                map.put(title, 1);
            }
        }

        String ans = "";
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (count < entry.getValue()) {
                ans = entry.getKey();
                count = entry.getValue();
            } else if (count == entry.getValue()) {
                if (ans.compareTo(entry.getKey()) > 0) {
                    ans = entry.getKey();;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}