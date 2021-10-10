package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18114_블랙프라이데이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] products = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            products[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(products);

        int ans = 0;
        if (binarySearch(products, M) || twoPointer(products, M) || find(products, M)) {
            ans = 1;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean find(int[] products, int weight) {

        for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                int temp = weight - products[i] - products[j];
                if (temp < 0 || products[i] == temp || products[j] == temp) continue;
                if (binarySearch(products, temp)) return true;
            }
        }

        return false;
    }

    public static boolean twoPointer(int[] products, int weight) {

        int left = 0, right = products.length - 1;

        while (left < right) {
            int mid = products[left] + products[right];

            if (mid > weight) right--;
            else if (mid < weight) left++;
            else return true;
        }

        return false;
    }

    public static boolean binarySearch(int[] products, int weight) {

        int left = -1, right = products.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (products[mid] < weight) left = mid;
            else right = mid;
        }

        return products[right] == weight;
    }
}
