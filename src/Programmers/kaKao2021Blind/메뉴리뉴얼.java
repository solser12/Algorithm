package Programmers.kaKao2021Blind;

import java.util.*;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {

        HashMap<Integer, HashMap<String, Integer>> totalCount = new HashMap<>();
        for (int c : course) {
            totalCount.put(c, new HashMap<>());
        }

        for (String o : orders) {
            char[] order = o.toCharArray();
            Arrays.sort(order);
            for (int c : course) {
                find(c, 0, 0, order, "", totalCount.get(c));
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (int c : course) {
            ArrayList<String> temp = new ArrayList<>();
            int maxCnt = 2;
            for (Map.Entry<String, Integer> entry : totalCount.get(c).entrySet()) {
                if (maxCnt < entry.getValue()) {
                    maxCnt = entry.getValue();
                    temp.clear();
                    temp.add(entry.getKey());
                } else if (maxCnt == entry.getValue()) {
                    temp.add(entry.getKey());
                }
            }
            result.addAll(temp);
        }
        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public static void find(int goal, int cnt, int index, char[] order, String pick, HashMap<String, Integer> count) {

        if (index >= order.length) {
            if (goal == cnt) {
                if (!count.containsKey(pick)) {
                    count.put(pick, 1);
                } else {
                    count.put(pick, count.get(pick) + 1);
                }
            }
            return;
        }

        find(goal, cnt + 1, index + 1, order, pick + order[index], count);
        find(goal, cnt, index + 1, order, pick, count);
    }
}
