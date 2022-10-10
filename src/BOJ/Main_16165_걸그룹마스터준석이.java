package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16165_걸그룹마스터준석이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> memberGroupSet = new HashMap<>();
        HashMap<String, LinkedList<String>> groupMemberSet = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            LinkedList<String> members = new LinkedList<>();
            int count = Integer.parseInt(br.readLine());
            for (int j = 0; j < count; j++) {
                String name = br.readLine();
                members.add(name);
                memberGroupSet.put(name, groupName);
            }
            Collections.sort(members);
            groupMemberSet.put(groupName, members);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                for (String s : groupMemberSet.get(input)) {
                    sb.append(s).append('\n');
                }
            } else {
                sb.append(memberGroupSet.get(input)).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
