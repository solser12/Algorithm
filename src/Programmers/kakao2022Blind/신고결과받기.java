package Programmers.kakao2022Blind;

import java.util.*;

public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, Integer> idToIndex = new HashMap<>();
        HashMap<String, HashSet<String>> targetToReport = new HashMap<>();
        int[] ans = new int[id_list.length];

        for (String id : id_list) {
            idToIndex.put(id, idToIndex.size());
            targetToReport.put(id, new HashSet<>());
        }

        for (String r : report) {
            StringTokenizer st = new StringTokenizer(r);
            String reporter = st.nextToken();
            String target = st.nextToken();

            HashSet<String> reporterCheck = targetToReport.get(target);

            reporterCheck.add(reporter);
        }

        for (Map.Entry<String, HashSet<String>> entry : targetToReport.entrySet()) {
            if (entry.getValue().size() >= k) {
                for (String s : entry.getValue()) {
                    ans[idToIndex.get(s)]++;
                }
            }
        }

        return ans;
    }
}
