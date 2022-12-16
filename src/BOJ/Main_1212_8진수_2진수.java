package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1212_8진수_2진수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Character, String> map = init();
        String str = br.readLine();
        sb.append(Integer.toString(str.charAt(0) -  '0', 2));
        for (int i = 1; i < str.length(); i++) {
            sb.append(map.get(str.charAt(i)));
        }

        System.out.println(sb);
        br.close();
    }

    public static HashMap<Character, String> init() {
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "000");
        map.put('1', "001");
        map.put('2', "010");
        map.put('3', "011");
        map.put('4', "100");
        map.put('5', "101");
        map.put('6', "110");
        map.put('7', "111");
        return map;
    }
}