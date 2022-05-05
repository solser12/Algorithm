package Programmers.kaKao2020Blind;

public class 문자열압축 {

    public static void main(String[] args) {

//        System.out.println(solution("aabbaccc"));
//        System.out.println(solution("ababcdcdababcdcd"));
//        System.out.println(solution("abcabcdede"));
//        System.out.println(solution("abcabcabcabcdededededede"));
//        System.out.println(solution("xababcdcdababcdcd"));
        System.out.println(solution("abcdabcdede"));
    }

    public static int solution(String s) {

        int ans = s.length();

        for (int i = 4; i <= s.length() / 2; i++) {

            String prev = s.substring(0, i);
            int sum = 0, start = i, end = start + i, sameCnt = 1;

            while (true) {

                if (end > s.length()) {
                    if (sameCnt > 1) {
                        sum += Math.log10(sameCnt) + i + 1;
                    } else {
                        sum += i;
                    }
                    sum += (s.length() - start);
                    break;
                }

                String temp = s.substring(start, end);
                if (prev.equals(temp)) {
                    sameCnt++;
                } else {
                    if (sameCnt > 1) {
                        sum += Math.log10(sameCnt) + i + 1;
                        sameCnt = 1;
                    } else {
                        sum += i;
                    }
                    prev = temp;
                }

                start = end;
                end += i;
            }

            ans = Math.min(ans, sum);
        }

        return ans;
    }
}
