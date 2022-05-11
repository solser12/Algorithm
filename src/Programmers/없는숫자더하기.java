package Programmers;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int ans = 45;
        for (int number : numbers) {
            ans -= number;
        }
        return ans;
    }
}
