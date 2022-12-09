package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_잃어버린_괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer mToken = new StringTokenizer(br.readLine(), "-");
        int ans = add(mToken.nextToken());
        int mSize = mToken.countTokens();
        for (int i = 0; i < mSize; i++) {
            ans -= add(mToken.nextToken());
        }

        System.out.println(ans);
        br.close();
    }

    public static int add(String str) {
        StringTokenizer st = new StringTokenizer(str, "+");
        int result = 0, tokenSize = st.countTokens();
        for (int i = 0; i < tokenSize; i++) {
            result += Integer.parseInt(st.nextToken());
        }
        return result;
    }
}
