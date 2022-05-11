package Programmers;

public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int ans = 0;
        for (int i = 0; i < absolutes.length; i++) {
            ans += (signs[i] ? 1 : -1) * absolutes[i];
        }
        return ans;
    }
}
