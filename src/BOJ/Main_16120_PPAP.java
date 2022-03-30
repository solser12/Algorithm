package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16120_PPAP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        boolean isPPAP = true;
        int pCnt = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'P') {
                pCnt++;
            } else {
                if (pCnt < 2 || i == input.length - 1 || input[i + 1] != 'P') {
                    isPPAP = false;
                    break;
                }

                i++;
                pCnt--;
            }
        }

        if (pCnt != 1) {
            isPPAP = false;
        }

        if (isPPAP) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }

        br.close();
    }
}
