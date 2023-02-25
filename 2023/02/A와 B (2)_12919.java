package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12919 {
	
	static int limit;
	static int answer=0;
	static String S,T;
	
	static void sub(String str) {
		if(answer==1) return;
		
		if(str.length()==S.length()) {
			if(str.equals(S)) {
				answer=1;
			}
			return;
		}
		
        if(str.charAt(0) == 'B') {
        	String substring = str.substring(1);
        	StringBuilder sb = new StringBuilder(substring);
        	String string = sb.reverse().toString();
        	sub(string);
        }
        if(str.charAt(str.length()-1) == 'A') {
        	sub(str.substring(0,str.length()-1));
        }
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		S = br.readLine();
		T = br.readLine();
		
		limit = T.length();
//		add(S);
		sub(T);
		
		System.out.println(answer);
		
	}

}
