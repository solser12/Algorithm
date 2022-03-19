import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자야구 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[] group = new int[5];
        int[] calc = new int[5];
        int[][] group_mix = {{0, 1, 2, 3}, {2, 3, 4, 5}, {4, 5, 6, 7}, {6, 7, 8, 9}, {8, 9, 0 ,1}};

        int sum = 0;
        for (int i = 0; i < 5; i++) {

            System.out.println(Arrays.toString(group_mix[i]));
            st = new StringTokenizer(br.readLine());
            int hit = Integer.parseInt(st.nextToken());
            int miss = Integer.parseInt(st.nextToken());

            calc[i] = hit + miss;
            sum += calc[i];
        }

        sum /= 2;
        group[0] = sum - (calc[1]+calc[3]);
        group[1] = sum - (calc[2]+calc[4]);
        group[2] = sum - (calc[0]+calc[3]);
        group[3] = sum - (calc[1]+calc[4]);
        group[4] = sum - (calc[0]+calc[2]);

        ////////////////////////////////////////////////////////////////////////////////

        int oneCnt = 0, twoCnt = 0;
        int[] nextArr = new int[4];
        int nextIdx = 0;
        int[] dummy = new int[4];
        int dummyIdx = 0;

        for (int i = 0; i < 5; i++) {
            if (group[i] == 1) {
                oneCnt++;
            } else if (group[i] == 2) {
                twoCnt++;
            } else {
                dummy[dummyIdx++] = i * 2;
                dummy[dummyIdx++] = i * 2 + 1;
            }
        }

        int[] a = new int[2], b = new int[2];
        boolean isA = false, isB = false;

        if (oneCnt == 4) {
            for (int i = 0; i < 5; i++) {
                if (group[i] == 1) {
                    if (!isA) {
                        a[0] = i * 2;
                        a[1] = i * 2 + 1;
                        isA = true;
                    } else if (!isB) {
                        b[0] = i * 2;
                        b[1] = i * 2 + 1;
                        isB = true;
                    }
                    if (isA && isB) {
                        int[] ans = find(a, b, dummy);
                        nextArr[nextIdx++] = ans[0];
                        nextArr[nextIdx++] = ans[1];
                        isA = false;
                        isB = false;
                    }
                }
            }
        } else if (oneCnt == 2 && twoCnt == 1) {
            for (int i = 0; i < 5; i++) {
                if (group[i] == 2) {
                    nextArr[nextIdx++] = i * 2;
                    nextArr[nextIdx++] = i * 2 + 1;
                } else if (group[i] == 1) {
                    if (!isA) {
                        a[0] = i * 2;
                        a[1] = i * 2 + 1;
                        isA = true;
                    } else if (!isB) {
                        b[0] = i * 2;
                        b[1] = i * 2 + 1;
                        isB = true;
                    }
                    if (isA && isB) {
                        int[] ans = find(a, b, dummy);
                        nextArr[nextIdx++] = ans[0];
                        nextArr[nextIdx++] = ans[1];
                        isA = false;
                        isB = false;
                    }
                }
            }

        } else if (twoCnt == 2) {
            for (int i = 0; i < 5; i++) {
                if (group[i] == 2) {
                    nextArr[nextIdx++] = i * 2;
                    nextArr[nextIdx++] = i * 2 + 1;
                }
            }
        }

        if (oneCnt == 4) {
            dummyIdx = 0;
            for (int i = 0; i <= 9; i++) {
                boolean isFind = false;
                for (int j = 0; j < 4; j++) {
                    if (nextArr[j] == i) {
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) {
                    dummy[dummyIdx++] = i;
                    if (dummyIdx > 3) break;
                }
            }
        }

        /////////////////////////////////////////////////////////////////////
        int maxIdx = 3;
        int[] answer = new int[4];
        boolean[] isFix = new boolean[4];
        int[] query = new int[4];

        for (int i = 0; i < 3; i++) {       // nextArr
            for (int j = 0; j < maxIdx + 1; j++) {   // 위치
                if (j == maxIdx) {
                    isFix[j] = true;
                    answer[j] = nextArr[i];
                    maxIdx--;
                    break;
                }

                if (isFix[j]) continue;

                // 초기화
                for (int k = 0; k < 4; k++) {
                    query[k] = -1;
                }

                query[j] = nextArr[i];
                for (int k = 0; k < 4; k++) {
                    if (query[k] == -1) {
                        query[k] = dummy[k];
                    }
                }

                System.out.println(Arrays.toString(query));
                st = new StringTokenizer(br.readLine());
                int hit = Integer.parseInt(st.nextToken());
                int miss = Integer.parseInt(st.nextToken());

                if (hit == 1) {
                    isFix[j] = true;
                    answer[j] = nextArr[i];
                    break;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!isFix[i]) {
                answer[i] = nextArr[3];
            }
        }

        System.out.println(Arrays.toString(answer));

        br.close();
    }

    public static int[] find(int[] a, int[] b, int[] dummy) throws IOException {
        int[] result = new int[2];
        int[] check = new int[4];

        check[0] = a[0];
        check[1] = b[0];
        check[2] = dummy[0];
        check[3] = dummy[1];

        System.out.println(Arrays.toString(check));
        st = new StringTokenizer(br.readLine());
        int hit = Integer.parseInt(st.nextToken());
        int miss = Integer.parseInt(st.nextToken());
        int ans = hit + miss;

        if (ans == 0) {
            result[0] = a[1];
            result[1] = b[1];
        } else if (ans == 2) {
            result[0] = a[0];
            result[1] = b[0];
        } else {
            check[1] = b[1];
            System.out.println(Arrays.toString(check));
            st = new StringTokenizer(br.readLine());
            hit = Integer.parseInt(st.nextToken());
            miss = Integer.parseInt(st.nextToken());
            ans = hit + miss;

            if (ans == 0) {
                result[0] = a[1];
                result[1] = b[0];
            } else if (ans == 2) {
                result[0] = a[0];
                result[1] = b[1];
            }
        }

        return result;
    }
}