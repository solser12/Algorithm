package Programmers;

public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
            } else {
                if (c <= 'Z') {
                    c += n;
                    if (c > 'Z') {
                        c = (char) ('A' + (c % 'Z') - 1);
                    }
                } else {
                    c += n;
                    if (c > 'z') {
                        c = (char) ('a' + (c % 'z') - 1);
                    }
                }
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
