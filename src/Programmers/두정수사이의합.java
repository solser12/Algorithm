package Programmers;

public class 두정수사이의합 {

    public long solution(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int count = max - min + 1;

        return (long) (count / 2) * (max + min) + (count % 2 == 1 ? (max + min) / 2 : 0);
    }
}
