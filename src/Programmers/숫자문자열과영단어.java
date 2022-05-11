package Programmers.kakao2021internship;

import java.util.HashMap;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {

        solution("one4seveneight");
    }

    public static HashMap<String, Integer> stringToInt = new HashMap<>();

    public static int solution(String s) {

        init();

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ('0' <= c && c <= '9') {
                result.append(c - '0');
            } else {
                temp.append(c);
                if (stringToInt.containsKey(temp.toString())) {
                    result.append(stringToInt.get(temp.toString()));
                    temp.setLength(0);
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    public static void init() {
        stringToInt.put("zero", 0);
        stringToInt.put("one", 1);
        stringToInt.put("two", 2);
        stringToInt.put("three", 3);
        stringToInt.put("four", 4);
        stringToInt.put("five", 5);
        stringToInt.put("six", 6);
        stringToInt.put("seven", 7);
        stringToInt.put("eight", 8);
        stringToInt.put("nine", 9);
    }
}
