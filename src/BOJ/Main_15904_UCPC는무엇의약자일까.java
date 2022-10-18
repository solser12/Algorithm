package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_15904_UCPC는무엇의약자일까 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String pattern = ".*U.*C.*P.*C.*";

        if (Pattern.matches(pattern, input)) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }

        br.close();
    }
}
