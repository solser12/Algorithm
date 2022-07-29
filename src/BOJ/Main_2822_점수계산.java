package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2822_점수계산 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Question[] questions = new Question[8];
        for (int i = 0; i < 8; i++) {
            questions[i] = new Question(i + 1, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(questions);

        int[] numbers = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            numbers[i] = questions[i].num;
            sum += questions[i].score;
        }
        Arrays.sort(numbers);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append('\n');
        for (int number : numbers) {
            sb.append(number).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Question implements Comparable<Question> {

        int num, score;

        public Question(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Question o) {
            return o.score - this.score;
        }
    }
}
