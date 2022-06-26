package Programmers;

public class 하샤드수 {
    public boolean solution(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int div = 0;
        for (char c : arr) {
            div += c - '0';
        }
        return  x % div == 0;
    }
}
