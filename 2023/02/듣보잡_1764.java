package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main_1764 {
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> listen = new HashSet<>();
		ArrayList<String> lisea = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			listen.add(tmp);
		}
		
		for(int i=0;i<M;i++) {
			String tmp = br.readLine();
			if(listen.contains(tmp)) {
				lisea.add(tmp);
			}
		}
		
		Collections.sort(lisea);
		
		sb.append(lisea.size() + "\n");
		
		for(String s : lisea) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
		
		
	}

}
