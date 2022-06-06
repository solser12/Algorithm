package Programmers;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

    public String solution(String s) {

        Character[] arr = new Character[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, (o1, o2) -> o2 - o1);

        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }

        return sb.toString();
    }
}
