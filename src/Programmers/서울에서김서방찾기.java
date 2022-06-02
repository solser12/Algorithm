package Programmers;

public class 서울에서김서방찾기 {

    public String solution(String[] seoul) {
        String result = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                result = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return result;
    }
}
