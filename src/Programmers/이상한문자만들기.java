package Programmers;

public class 이상한문자만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String temp = s.toLowerCase();

        int sw = 1;
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c != ' ' && sw == 1) {
                c -= 32;
            }
            sb.append(c);

            if (c == ' ') {
                sw = 1;
            } else {
                sw *= -1;
            }
        }

        return sb.toString();
    }
}
