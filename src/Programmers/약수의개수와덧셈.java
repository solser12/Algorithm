package Programmers;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (squared((int) Math.sqrt(i)) == i) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }

    public int squared(int num) {
        return num * num;
    }
}
