package day0403;

import java.io.*;
import java.util.*;

public class Main_bj_16987_계란으로계란치기 {
	
	static int N;
	static int[][] eggs;

	static final int power = 0;
	static final int weight =1;
	
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		eggs = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][power] = Integer.parseInt(st.nextToken());
			eggs[i][weight] = Integer.parseInt(st.nextToken());
		}
		
		backTracking(0,0);
		System.out.println(answer);

	}
	
	static void backTracking(int idx, int broken) {
		if(idx==N ||broken==N-1) {
			answer = Math.max(answer, broken);
			return;
		} 
		if(eggs[idx][power]<=0 ) {
			backTracking(idx+1, broken);
			return;
		}
		
		int count = broken;
		for(int i=0;i<N;i++) {
			if(i==idx) continue;
			if(eggs[i][power]<=0) continue;
			eggs[idx][power]-=eggs[i][weight];
			eggs[i][power]-=eggs[idx][weight];
			if(eggs[i][power]<=0) count++;
			if(eggs[idx][power]<=0) count++;
			
			backTracking(idx+1, count);
			
			eggs[idx][power]+=eggs[i][weight];
			eggs[i][power]+=eggs[idx][weight];
			count = broken;
		}
	}

}
