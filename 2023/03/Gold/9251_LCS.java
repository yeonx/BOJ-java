package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9251_LCS {
	
	static int[][] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		dp = new int[str2.length()+1][str1.length()+1];

		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[j][i] = dp[j-1][i-1] + 1;
				} else {
					dp[j][i] = Integer.max(dp[j-1][i], dp[j][i-1]);
				}
			}
		}
		
		System.out.println(dp[str2.length()][str1.length()]);


	}

}
