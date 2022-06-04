package Programmers;

public class 가운데글자가져오기 {

    public String solution(String s) {
        return s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);
    }
}
