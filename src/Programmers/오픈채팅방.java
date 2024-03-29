package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 오픈채팅방 {

    public String[] solution(String[] record) {

        HashMap<String, String> hashmap = new HashMap<>();
        ArrayList<Info> info = new ArrayList<>();
        StringTokenizer st;

        for (String s : record) {
            st = new StringTokenizer(s, " ");
            char type = st.nextToken().charAt(0);
            String uid = st.nextToken();

            if (type == 'E') {
                String nickname = st.nextToken();
                hashmap.put(uid, nickname);
                info.add(new Info(uid, 0));
            } else if (type == 'L') {
                info.add(new Info(uid, 1));
            } else {
                String nickname = st.nextToken();
                hashmap.put(uid, nickname);
            }
        }

        String[] ans = new String[info.size()];
        for (int i = 0; i < ans.length; i++) {
            Info temp = info.get(i);
            if (temp.type == 0) {
                ans[i] = hashmap.get(temp.uid) + "님이 들어왔습니다.";
            } else {
                ans[i] = hashmap.get(temp.uid) + "님이 나갔습니다.";
            }
        }

        return ans;
    }

    public class Info {
        String uid;
        int type;

        public Info(String uid, int type) {
            this.uid = uid;
            this.type = type;
        }
    }
}
