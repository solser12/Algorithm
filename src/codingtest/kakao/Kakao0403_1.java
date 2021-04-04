package codingtest.kakao;

import java.util.ArrayList;

class Kakao0403_1 {

    public static int solution(int[] gift_cards, int[] wants) {
        ArrayList<Integer>[] have = new ArrayList[100001];
        int size = gift_cards.length;
        int ans = gift_cards.length;

        for (int i = 0; i < size; i++) {
            if (gift_cards[i] == wants[i]) {
                wants[i] = 0;
                ans--;
                continue;
            }

            if (have[gift_cards[i]] == null) {
                have[gift_cards[i]] = new ArrayList<>();
            }

            have[gift_cards[i]].add(i);
        }

        while (true) {
            boolean isChange = false;
            for (int i = 0; i < size; i++) {
                // 이미 원하는 걸 얻었을 경우
                if (wants[i] == 0) continue;
                // 원하는 카드가 없어도 continue
                if (have[wants[i]] == null || have[wants[i]].isEmpty()) {
                    // 없는 카드이므로 처리
                    wants[i] = 0;
                    continue;
                }
                // 원하는 카드가 있으면 바꿔주기
                // 카드를 갖고있는 사람
                int target = have[wants[i]].get(0);
                // 갖고있는거 꺼내기
                have[wants[i]].remove(0);
                // 서로 원하는걸 갖고 있으면 바꾸고 전부 지우기
                if (gift_cards[i] == wants[target] && gift_cards[target] == wants[i]) {
                    have[gift_cards[i]].remove(Integer.valueOf(i));
                    wants[target] = 0;
                    wants[i] = 0;
                    ans -= 2;
                } else {
                    // 내카드를 주기
                    have[gift_cards[i]].add(target);
                    // 나는 만족하니깐 0
                    wants[i] = 0;
                    // 내 기록 지우기
                    have[gift_cards[i]].remove(Integer.valueOf(i));
                    ans--;
                }
                isChange = true;
            }

            if (!isChange) break;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] gift_cards = new int[100000];
        int[] wants = new int[100000];

        for (int i = 1; i < 100001; i++) {
            gift_cards[i - 1] = i;
            wants[i - 1] = 100001 - i;
        }
        System.out.println(solution(gift_cards, wants));
    }
}


