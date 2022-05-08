package Programmers.월간코드챌린지시즌1;

public class 내적 {
    public int solution(int[] a, int[] b) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }
}
