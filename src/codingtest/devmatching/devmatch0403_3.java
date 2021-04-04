package codingtest.devmatching;

import java.util.HashMap;

public class devmatch0403_3 {

    int[] parents;
    int[] ans;
    int num;
    HashMap<String, Integer> map = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        num = enroll.length;
        parents = new int[num];
        ans = new int[num];

        // 이름 index 매핑
        for (int i = 0; i < num; i++) {
            map.put(enroll[i], i);
        }

        // 상관 찾기
        for (int i = 0; i < num; i++) {
            String ref = referral[i];
            // "-" 상관 없음
            if (ref.equals("-")) {
                parents[i] = -1;
            } else {
                // 상관 번호찾아서 넣기
                int parent = map.get(ref);
                parents[i] = parent;
            }
        }

        for (int i = 0; i < seller.length; i++) {
            // 판매사원 인덱스 찾기
            int s = map.get(seller[i]);
            int money = amount[i] * 100;
            // 계산하기
            calc(s, money);
        }

        return ans;
    }


    private void calc(int s, int money) {
        // 상관찾기
        int parent = parents[s];
        // 상관 없으면 그냥 return
        if (parent == -1) {
            ans[s] += money - (money / 10);
            return;
        }

        // 상관에 넘길 10% 계산
        int sendMoney = money / 10;
        // 내가 버는 돈
        int resultMoney = money - sendMoney;
        ans[s] += resultMoney;

        if (sendMoney > 0) calc(parent, sendMoney);
    }

    public void make() {
        for (int i = 0; i < num; i++) {
            parents[i] = i;
        }
    }
}
