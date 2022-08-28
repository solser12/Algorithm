package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_4659_비밀번호발음하기 {

    public static boolean first, second, third;
    public static int secondCnt;
    public static char thirdTemp;
    public static HashSet<Character> vowel = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        String input;
        while (!(input = br.readLine()).equals("end")) {
            first = false;
            second = true;
            third = true;
            secondCnt = 0;
            thirdTemp = ' ';

            char[] arr = input.toCharArray();
            for (char c : arr) {
                if (!first) {
                    firstCheck(c);
                }
                if (second) {
                    secondCheck(c);
                }
                if (third) {
                    thirdCheck(c);
                }
            }

            sb.append('<').append(input).append("> is ");
            if (first && second && third) {
                sb.append("acceptable.");
            } else {
                sb.append("not acceptable.");
            }
            sb.append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static void firstCheck(char c) {
        if (vowel.contains(c)) {
            first = true;
        }
    }

    public static void secondCheck(char c) {
        if (vowel.contains(c)) {
            if (secondCnt > 0) {
                secondCnt++;
                if (secondCnt == 3)  {
                    second = false;
                }
            } else {
                secondCnt = 1;
            }
        } else {
            if (secondCnt < 0) {
                secondCnt--;
                if (secondCnt == -3) {
                    second = false;
                }
            } else {
                secondCnt = -1;
            }
        }
    }

    public static void thirdCheck(char c) {
        if (thirdTemp == c) {
            third = false;
            return;
        }
        if (c == 'e' || c == 'o') {
            return;
        }
        thirdTemp = c;
    }
}
