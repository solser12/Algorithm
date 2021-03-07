package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Schedule[] list = new Schedule[N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            list[i] = new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(list);

        int cnt = 1, last = list[0].end;
        for (int i = 1; i < list.length; ++i) {
            if (last <= list[i].start) {
                last = list[i].end;
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    static class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        Schedule (int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Schedule s) {
            int result = Integer.compare(this.end, s.end);
            if (result != 0)  return result;
            else return this.start > s.start ? 1 : -1;
        }
    }
}
