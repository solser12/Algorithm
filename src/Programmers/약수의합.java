package Programmers;

public class 약수의합 {

    public int solution(int n) {

        int ans = 0;
        int i = 1;
        for ( ;i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans += (i + (n / i));
            }
        }

        if (i * i == n) {
            ans += i;
        }

        return ans;
    }
}
