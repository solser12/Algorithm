package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18868_멀티버스Ⅰ {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // bufferedReader로 데이터 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());                    // 학급 수, 학생 수를 공백 기준으로 쪼갬

        int M = Integer.parseInt(st.nextToken());               // 학급의 개수
        int N = Integer.parseInt(st.nextToken());               // 학생 수
        int cnt = 0;                                            // 학급 쌍의 개수

        int[] list = new int [N];                               // 학생들 성적 정보를 입력받아 결과값을 미리 저장해 두는 곳
        int[][] check =  new int[M][(N*(N-1))/2];               // 반별 조건을 저장할 리스트 (NC2)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());            // 학생 성적 데이터를 공백 기준으로 쪼갬
            for (int j = 0; j < N; j++) {
                list[j] = Integer.parseInt(st.nextToken());     // 학생 성적을 리스트에 순차적으로 저장
            }

            int index = 0;                                      // check 배열 순차적으로 입력을 위한 index 위치
            for (int m = 0; m < N-1; m++) {                     // 1반부터 N-1 반까지
                for (int n = m + 1; n < N; n++) {               // m+1반부터 N 반까지
                    // 반 학생 성적 비교 결과를 check에 미리 저장해 놓기
                    check[i][index++] = list[m] > list[n] ? 1 : (list[m] < list[n] ? -1 : 0);
                }
            }
        }

        for (int i = 0; i < M-1; i++) {                         // 첫번째 비교반
            for (int j = i+1; j < M; j++) {                     // 두번째 비교반
                for (int k = 0; k < check[i].length; k++) {     // check에 저장된 학생 성적 비교 결과를 확인
                    if (check[i][k] != check[j][k]) {           // 저장된 check를 이용해 2개 반끼리 비교하기
                        cnt--;                                  // break되면 cnt가 자동으로 +1되므로 -1시키기
                        break;
                    }
                }
                cnt++;                                          // cnt++;
            }
        }

        System.out.println(cnt);                                // cnt 출력
        br.close();                                             // BufferedReader 닫기
    }
}
