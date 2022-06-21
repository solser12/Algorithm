package Programmers;

public class 소수찾기2 {
    public int solution(int n) {
        boolean[] primeNumbers = new boolean[n + 1];
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (primeNumbers[i]) {
                continue;
            }
            ans++;
            for (int j = i; j <= n; j += i) {
                primeNumbers[j] = true;
            }
        }
        return ans;
    }
}