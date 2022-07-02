package Programmers;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        return countChar(s, 'p') == countChar(s, 'y');
    }

    int countChar(String s, char ch) {
        return (int) s.chars().
                filter(c -> c == ch || (c + 32) == ch)
                .count();
    }
}
