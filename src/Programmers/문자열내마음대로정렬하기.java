package Programmers;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        String[] ans = strings.clone();
        Arrays.sort(ans, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        return ans;
    }
}
