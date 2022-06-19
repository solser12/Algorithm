package Programmers;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        long ans = 0, index = 1;
        for (char c : arr) {
            ans += index * (c - '0');
            index *= 10;
        }
        return ans;
    }
}
