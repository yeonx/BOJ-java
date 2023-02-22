package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1620 {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> intMap = new HashMap<>();
		HashMap<String,Integer> stringMap = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			intMap.put(i+1, tmp);
			stringMap.put(tmp, i+1);
			
		}
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if('1'<=s.charAt(0)&&s.charAt(0)<='9') {
				sb.append(intMap.get(Integer.parseInt(s)) + "\n");
			} else {
				sb.append(stringMap.get(s) +"\n");
			}
		}
		System.out.println(sb);
	}

}
