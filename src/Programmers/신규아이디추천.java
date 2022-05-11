package Programmers;

public class 신규아이디추천 {

    public String solution(String new_id) {

        char[] id = new_id.toCharArray();
        for (int i = 0; i < id.length; i++) {
            if ('A' <= id[i] && id[i] <= 'Z') {
                id[i] += 32;
            }

            if (!checkChar(id[i])) {
                id[i] = '+';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : id) {
            if (c == '+') continue;
            sb.append(c);
        }
        id = sb.toString().toCharArray();

        for (int i = 0; i < id.length - 1; i++) {
            if (id[i] == '.' && id[i + 1] == '.') {
                id[i] = '+';
            }
        }

        sb = new StringBuilder();
        for (char c : id) {
            if (c == '+') continue;
            sb.append(c);
        }

        while (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.delete(0, 1);
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.setLength(sb.length() - 1);
        }

        if (sb.length() == 0) {
            sb.append('a');
        }

        if (sb.length() > 15) {
            sb.setLength(15);
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.setLength(sb.length() - 1);
        }

        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }

    public boolean checkChar(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || (c == '-') || (c == '.') || (c == '_');
    }
}
