package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2535_아시아_정보올림피아드 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            students[i] = new Student(country, num, score);
        }
        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (Student student : students) {

            if (!map.containsKey(student.country)) {
                map.put(student.country, 1);
                sb.append(student.country).append(' ').append(student.num).append('\n');
                cnt++;
            } else {
                if (map.get(student.country) == 1) {
                    map.put(student.country, map.get(student.country) + 1);
                    sb.append(student.country).append(' ').append(student.num).append('\n');
                    cnt++;
                }
            }

            if (cnt > 2) {
                break;
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Student implements Comparable<Student> {
        int country, num, score;

        public Student(int country, int num, int score) {
            this.country = country;
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }
}
