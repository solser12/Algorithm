package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1373_2진수_8진수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = init();

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for (int i = input.length(); i > 0; i -= 3) {
            sb.insert(0, map.get(Integer.parseInt(input.substring(Math.max(i - 3, 0), i))));
        }

        System.out.println(sb);
        br.close();
    }

    public static HashMap<Integer, Integer> init() {
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(0, 0);
        result.put(1, 1);
        result.put(10, 2);
        result.put(11, 3);
        result.put(100, 4);
        result.put(101, 5);
        result.put(110, 6);
        result.put(111, 7);
        return result;
    }
}
