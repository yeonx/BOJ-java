package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11723 {
	
	static HashSet<Integer> set = new HashSet<>();


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int number;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			if(command.equals("add")) {
				number = Integer.parseInt(st.nextToken());
				set.add(number);
			} else if (command.equals("remove")) {
				number = Integer.parseInt(st.nextToken());
				set.remove(number);
			} else if(command.equals("empty")) {
				set = new HashSet<>();
			} else if(command.equals("all")) {
				set = new HashSet<>();
				for(int n=1;n<=20;n++) {
					set.add(n);
				}
			} else if(command.equals("toggle")) {
				number = Integer.parseInt(st.nextToken());
				if(set.contains(number)) {
					set.remove(number);
				} else {
					set.add(number);
				}
			} else {
				number = Integer.parseInt(st.nextToken());
				if(set.contains(number)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}
