package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 후보키 {

    public int solution(String[][] relation) {

        int ans = 0;
        int size = relation[0].length;
        int depth = relation.length;
        boolean[] visited = new boolean[1 << size];
        ArrayList<Data> pick = new ArrayList<>();

        for (int choice = 1; choice < (1 << size); choice++) {
            int bit = 1, idx = 0, cnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (bit < (1 << size)) {
                if ((choice & bit) > 0) {
                    list.add(idx);
                    cnt++;
                }
                idx++;
                bit <<= 1;
            }
            pick.add(new Data(choice, cnt, list));
        }
        Collections.sort(pick);

        for (Data data : pick) {
            boolean flag = false;
            for (int i = 1; i < data.bit; i++) {
                if (visited[i] && (data.bit & i) == i) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < depth; i++) {
                StringBuilder s = new StringBuilder();
                for (int idx : data.list) {
                    s.append(relation[i][idx]);
                }
                if (set.contains(s.toString())) {
                    flag = true;
                    break;
                }

                set.add(s.toString());
            }

            if (flag) continue;

            ans++;
            visited[data.bit] = true;
        }

        return ans;
    }

    public class Data implements Comparable<Data> {
        int bit, count;
        ArrayList<Integer> list;

        public Data(int bit, int count, ArrayList<Integer> list) {
            this.bit = bit;
            this.count = count;
            this.list = list;
        }

        @Override
        public int compareTo(Data o) {
            if (this.count == o.count) return this.bit - o.bit;
            return this.count - o.count;

        }
    }
}