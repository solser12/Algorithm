package Programmers.Kakao2018Blind;

import java.util.Arrays;

public class 다트게임 {

    public static void main(String[] args) {

        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {

        char[] order = dartResult.toCharArray();

        int[] pow = new int[3];
        int[] mul = new int[3];
        Arrays.fill(mul, 1);
        int idx = 0;

        int type = 0;
        for (int i = 0; i < order.length; i++) {
            char c = order[i];
            if (type == 0) {
                if (order[i+1] != '0') {
                    pow[idx] = c - '0';
                } else {
                    pow[idx] = 10;
                    i++;
                }
            } else if (type == 1) {
                if (c == 'D') {
                    pow[idx] = (int) Math.pow(pow[idx], 2);
                } else if (c == 'T') {
                    pow[idx] = (int) Math.pow(pow[idx], 3);
                }
            } else {
                if (c == '*') {
                    mul[idx] *= 2;
                    if (idx != 0) mul[idx-1] *= 2;
                } else if (c == '#') {
                    mul[idx] *= -1;
                } else {
                    i--;
                }
                idx++;
                type = -1;
            }
            type++;
        }

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += pow[i] * mul[i];
        }

        return ans;
    }
}
