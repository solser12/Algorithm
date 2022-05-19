package Programmers;

import java.util.LinkedHashMap;

public class 다단계칫솔판매 {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        LinkedHashMap<String, Seller> sellers = new LinkedHashMap<>();
        for (String e : enroll) {
            sellers.put(e, new Seller());
        }
        
        for (int i = 0; i < enroll.length; i++) {
            
            if (referral[i].equals("-")) {
                continue;
            }

            Seller child = sellers.get(enroll[i]);
            Seller parent = sellers.get(referral[i]);
            child.setParent(parent);
        }

        for (int i = 0; i < seller.length; i++) {
            sellers.get(seller[i]).calculate(amount[i] * 100);
        }

        int[] ans = new int[sellers.size()];
        int index = 0;
        for (Seller s : sellers.values()) {
            ans[index++] = s.money;
        }

        return ans;
    }

    public class Seller {

        Seller parent = null;
        int money = 0;

        public void setParent(Seller parent) {
            this.parent = parent;
        }

        public void calculate(int profits) {
            int temp = profits / 10;
            money += profits - temp;
            if (parent != null && temp > 0) {
                parent.calculate(temp);
            }
        }
    }
}
