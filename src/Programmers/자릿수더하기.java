package Programmers;

public class 자릿수더하기 {
    public int solution(int n) {
        String num = String.valueOf(n);
        int ans = 0;
        for (int i = 0; i < num.length(); i++) {
            ans += num.charAt(i) - '0';
        }
        return ans;
    }
}
