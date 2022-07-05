package Programmers;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        return calc(Math.max(n, m), Math.min(n, m));
    }

    public int[] calc(int n, int m) {
        int a = n;
        int b = m;
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return new int[] {a, (n * m / a)};
    }
}
