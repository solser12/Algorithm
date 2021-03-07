package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Solution_1210_Ladder1 {

    public static void main(String[] args) throws IOException {     
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	
        boolean[][] ladder = new boolean[100][100];
        int[] loc = new int[2];
        int T = 10;
        int temp;
        String s;
        
	    for ( int t = 1; t <= T; t++) {
	    	s = br.readLine();
	        
	    	for ( int i = 0; i < 100; i++) {
	    		
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		
	        	for ( int j = 0; j < 100; j++) {
	        		temp = Integer.parseInt(st.nextToken());
	        		
	        		switch (temp) {
        			case 0:
        				ladder[i][j] = false;
        				break;
        			case 1:
        				ladder[i][j] = true;
        				break;
        			case 2:
        				ladder[i][j] = true;
        				loc[1] = j;
        				loc[0] = 99;
        				break;
	        		}
	        	}
	    	}
	    	
        	while (loc[0] != 0) {
        		if (loc[1] - 1 >= 0 && ladder[loc[0]][loc[1]-1]) {
        			do {
        				loc[1]--;
        				if (ladder[loc[0]-1][loc[1]]) {
        					loc[0]--;
        					break;
        				}
        			} while(true); 
        		}
        		else if (loc[1] + 1 < 100 && ladder[loc[0]][loc[1]+1]) {
        			do {
        				loc[1]++;
        				if (ladder[loc[0]-1][loc[1]]) {
        					loc[0]--;
        					break;
        				}
        			} while(true); 
        		}
        		else {
        			loc[0]--;
        		}
        	}
        	
	    	sb.append("#").append(t).append(" ").append(loc[1]).append("\n");
	    }       
	    
        System.out.print(sb.toString());
        
        br.close();
    }
}