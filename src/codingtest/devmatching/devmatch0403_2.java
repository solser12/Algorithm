package codingtest.devmatching;

public class devmatch0403_2 {

    int[][] table;

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] ans = new int[queries.length];

        table = new int [columns][rows];
        int num = 1;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                table[i][j] = num++;
            }
        }

        int t;
        for (t = 0; t < queries.length - 1; t++) {
            int result = moveAndCheck(queries[t][0] - 1, queries[t][1] - 1,  queries[t][2] - 1, queries[t][3] - 1);
            ans[t] = result;
        }

        ans[t] = check(queries[t][0] - 1, queries[t][1] - 1,  queries[t][2] - 1, queries[t][3] - 1);

        return ans;
    }

    public int moveAndCheck(int x1, int y1, int x2, int y2) {
        int temp = table[x1][y2];;
        int min = temp;
        // >
        for (int i = y2; i > y1; i--) {
            min = Math.min(min, table[x1][i-1]);
            table[x1][i] = table[x1][i-1];
        }
        // ^
        for (int i = x1; i < x2; i++) {
            min = Math.min(min, table[i+1][y1]);
            table[i][y1] = table[i+1][y1];
        }
        // <
        for (int i = y1; i < y2; i++) {
            min = Math.min(min, table[x2][i+1]);
            table[x2][i] = table[x2][i+1];
        }
        // v
        for (int i = x2; i > x1 + 1; i--) {
            min = Math.min(min, table[i-1][y2]);
            table[i][y2] = table[i-1][y2];
        }

        table[x1+1][y2] = temp;

        return min;
    }

    public int check(int x1, int y1, int x2, int y2) {
        int min = Integer.MAX_VALUE;
        // >
        for (int i = y2; i > y1; i--) {
            min = Math.min(min, table[x1][i-1]);
        }
        // ^
        for (int i = x1; i < x2; i++) {
            min = Math.min(min, table[i+1][y1]);
        }
        // <
        for (int i = y1; i < y2; i++) {
            min = Math.min(min, table[x2][i+1]);
        }
        // v
        for (int i = x2; i > x1; i--) {
            min = Math.min(min, table[i-1][y2]);
        }
        return min;
    }
}
