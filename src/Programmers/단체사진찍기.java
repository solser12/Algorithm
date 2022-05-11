package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 단체사진찍기 {
    public int solution(int n, String[] data) {

        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        HashMap<Character, Integer> friendToIndex = new HashMap<>();
        for (char friend : friends) {
            friendToIndex.put(friend, friendToIndex.size());
        }

        HashMap<Character, ArrayList<Rule>> rules = makeRule(friends, data);

        int answer = 0;
        do {
            if (checkRule(friendToIndex, rules)) {
                answer++;
                System.out.println(Arrays.toString(friends));
            }
        } while (nextPermutation(friendToIndex, friends));

        return answer;
    }

    public boolean checkRule(HashMap<Character, Integer> friendToIndex, HashMap<Character, ArrayList<Rule>> rules) {
        for (Map.Entry<Character, ArrayList<Rule>> entry : rules.entrySet()) {
            for (Rule rule : entry.getValue()) {
                if (!rule.check(friendToIndex.get(entry.getKey()), friendToIndex.get(rule.target))) {
                    return false;
                }
            }
        }

        return true;
    }

    public HashMap<Character, ArrayList<Rule>> makeRule(char[] friends, String[] data) {

        HashMap<Character, ArrayList<Rule>> rules = new HashMap<>();
        for (char friend : friends) {
            rules.put(friend, new ArrayList<>());
        }

        for (String d : data) {
            ArrayList<Rule> rule = rules.get(d.charAt(0));
            rule.add(new Rule(d.charAt(2), d.charAt(3), d.charAt(4) - '0'));
        }

        return rules;
    }

    public boolean nextPermutation(HashMap<Character, Integer> friendToIndex, char[] friends) {

        int i = friends.length - 1;
        while (i > 0 && friends[i - 1] >= friends[i]) i--;
        if (i == 0) return false;

        int j = friends.length - 1;
        while (friends[i - 1] >= friends[j]) j--;

        char temp = friends[i - 1];
        friends[i - 1] = friends[j];
        friends[j] = temp;
        friendToIndex.put(friends[j], j);
        friendToIndex.put(friends[i - 1], i - 1);

        j = friends.length - 1;
        while (i < j) {
            temp = friends[i];
            friends[i] = friends[j];
            friends[j] = temp;
            friendToIndex.put(friends[i], i);
            friendToIndex.put(friends[j], j);
            i++;
            j--;
        }

        return true;
    }

    public class Rule {
        char target, type;
        int value;

        public Rule(char target, char type, int value) {
            this.target = target;
            this.type = type;
            this.value = value;
        }

        public boolean check(int yourIndex, int myIndex) {
            if (type == '=') {
                return Math.abs(yourIndex - myIndex) - 1 == value;
            } else if (type == '>') {
                return Math.abs(yourIndex - myIndex) - 1 > value;
            } else {
                return Math.abs(yourIndex - myIndex) - 1 < value;
            }
        }
    }
}
