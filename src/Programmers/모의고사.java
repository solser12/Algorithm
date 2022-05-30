package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public int[] solution(int[] answers) {

        Student[] students = new Student[3];
        students[0] = new Student(new int[] {1, 2, 3 , 4, 5}, 1);
        students[1] = new Student(new int[] {2, 1, 2, 3, 2, 4, 2, 5}, 2);
        students[2] = new Student(new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3);

        for (int answer : answers) {
            for (Student student : students) {
                student.check(answer);
            }
        }

        Arrays.sort(students);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(students[0].loc);
        for (int i = 1; i < 3; i++) {
            if (students[i - 1].correct > students[i].correct) {
                break;
            }
            temp.add(students[i].loc);
        }

        int[] ans = new int[temp.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public class Student implements Comparable<Student> {

        int[] answer;
        int loc, index = 0, correct = 0;

        public Student(int[] answer, int loc) {
            this.answer = answer;
            this.loc = loc;
        }

        public void check(int num) {
            if (answer[index] == num) {
                correct++;
            }
            index = (index + 1) % answer.length;
        }

        @Override
        public int compareTo(Student o) {
            if (o.correct == this.correct) {
                return this.loc - o.loc;
            }
            return o.correct - this.correct;
        }
    }
}
