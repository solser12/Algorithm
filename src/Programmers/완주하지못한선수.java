package Programmers;

import java.util.HashMap;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> participants = new HashMap<>();
        for (String s : participant) {
            if (!participants.containsKey(s)) {
                participants.put(s, 1);
            } else {
                participants.put(s, participants.get(s) + 1);
            }
        }

        for (String s : completion) {
            int count = participants.get(s);
            if (count == 1) {
                participants.remove(s);
            } else {
                participants.put(s, count - 1);
            }
        }

        String ans = "";
        for (String s : participants.keySet()) {
            ans = s;
        }

        return ans;
    }
}
