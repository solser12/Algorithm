package Programmers;

public class 평균구하기 {
    public double solution(int[] arr) {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }
}
