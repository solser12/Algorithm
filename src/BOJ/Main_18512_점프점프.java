package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18512_점프점프 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // BufferedReader를 통해 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());                    // StringTokenizer로 입력 값을 공백기준으로 쪼갬

        int X = Integer.parseInt(st.nextToken());       // 김싸피 보폭
        int Y = Integer.parseInt(st.nextToken());       // 박싸피 보폭
        int H1 = Integer.parseInt(st.nextToken());      // 김싸피 집
        int H2 = Integer.parseInt(st.nextToken());      // 박싸피 집
        int dist1 = H1, dist2 = H2;                     // 김싸피, 박싸피가 뛴 거리

        while(true) {
            if (dist1 > dist2) {            // 김싸피가 멀리있으면
                dist2 += Y;                 // 박싸피가 뛴다.
            }
            else if (dist1 < dist2) {       // 박싸피가 멀리있으면
                dist1 += X;                 // 김사피가 뛴다.
            }
            else break;                     // 같으면 break

            if (dist1 >= 10000 || dist2 >= 10000) {     // 뛴거리가 10000이 넘었으면
                dist1 = -1;                             // dist1(출력할 거리)를 -1로 변경 후
                break;                                  // return
            }
        }

        System.out.println(dist1);                      // 뛴 거리 출력
        br.close();                                     // BufferedReader 닫기
    }
}