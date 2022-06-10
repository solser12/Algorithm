package Programmers;

public class 문자열다루기기본 {

    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && !s.matches(".*[a-zA-Z].*");
    }
}
