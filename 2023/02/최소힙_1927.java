package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1927 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number==0) {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(number);
			}
		}
		System.out.println(sb);
	
	}

}
