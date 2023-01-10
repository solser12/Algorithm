package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1076_저항 {

    public static HashMap<String, Integer> value = new HashMap<>();
    public static HashMap<String, Integer> mul = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();
        StringBuilder sb = new StringBuilder();
        sb.append(value.get(br.readLine()));
        sb.append(value.get(br.readLine()));
        long ans = Long.parseLong(sb.toString()) * mul.get(br.readLine());
        System.out.println(ans);
        br.close();
    }

    public static void init() {
        value.put("black", 0);
        value.put("brown", 1);
        value.put("red", 2);
        value.put("orange", 3);
        value.put("yellow", 4);
        value.put("green", 5);
        value.put("blue", 6);
        value.put("violet", 7);
        value.put("grey", 8);
        value.put("white", 9);

        mul.put("black", 1);
        mul.put("brown", 10);
        mul.put("red", 100);
        mul.put("orange", 1000);
        mul.put("yellow", 10000);
        mul.put("green", 100000);
        mul.put("blue", 1000000);
        mul.put("violet", 10000000);
        mul.put("grey", 100000000);
        mul.put("white", 1000000000);
    }
}
