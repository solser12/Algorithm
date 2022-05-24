package Programmers;

import java.util.HashSet;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {

        int[] ans = new int[2];

        HashSet<String> duplicationCheck = new HashSet<>();

        int user = 1, turn = 1;
        char end = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (duplicationCheck.contains(words[i]) || end != words[i].charAt(0)) {
                ans[0] = user;
                ans[1] = turn;
                break;
            }

            duplicationCheck.add(words[i]);
            end = words[i].charAt(words[i].length() - 1);
            user++;
            if (user > n) {
                turn++;
                user = 1;
            }
        }

        return ans;
    }
}
