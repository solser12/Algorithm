package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        int len, cnt;
        String m;
        
        for ( int t = 0; t < T; t++) {
        	m = br.readLine();
        	len = m.length();
        	cnt = 0;
        	
        	if (m.charAt(0) == '1') cnt++;
        	
        	for (int i = 0; i < len-1; i++) {
        		if (m.charAt(i) != m.charAt(i+1)) cnt++;
        	}
        	
        	sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
        }
        
        bw.write(sb.toString());
        
        br.close();
        bw.close();
	}
}
