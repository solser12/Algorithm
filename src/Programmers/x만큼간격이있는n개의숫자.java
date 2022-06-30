package Programmers;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        long[] ans = new long[n];
        ans[0] = x;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + x;
        }
        return ans;
    }
}
