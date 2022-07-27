package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5635_생일 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        sb.append(students[n - 1].name).append('\n').append(students[0].name);

        System.out.println(sb);
        br.close();
    }

    public static class Student implements Comparable<Student> {

        String name;
        LocalDate date;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.date = LocalDate.of(year, month, day);
        }

        @Override
        public int compareTo(Student o) {
            return this.date.compareTo(o.date);
        }
    }
}
