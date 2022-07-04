package Programmers;

public class 정수제곱근판별 {
    public long solution(long n) {
        long ans = -1;
        double sqrt = Math.sqrt(n);
        if (sqrt - (long)sqrt == 0) {
            ans = (long) Math.pow(sqrt + 1, 2);
        }
        return ans;
    }
}
