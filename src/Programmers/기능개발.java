package Programmers;

import java.util.ArrayList;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> temp = new ArrayList<>();
        int day = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]), distributeCnt = 1;

        for (int i = 1; i < progresses.length; i++) {
            int workingDay = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if (workingDay <= day) {
                distributeCnt++;
            } else {
                day = workingDay;
                temp.add(distributeCnt);
                distributeCnt = 1;
            }
        }

        temp.add(distributeCnt);

        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
