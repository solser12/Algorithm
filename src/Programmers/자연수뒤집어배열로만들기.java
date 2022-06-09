package Programmers;

public class 자연수뒤집어배열로만들기 {

    public int[] solution(long n) {
        int[] ans = new int[(int) (Math.log10(n) + 1)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (n % 10);
            n /= 10;
        }
        return ans;
    }
}
