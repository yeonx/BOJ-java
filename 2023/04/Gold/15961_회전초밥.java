package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_15961_회전초밥 {
	
	static int N, d, k,c;
	
	static int[] sushi;
	
	static int answer = 0;
	
	static void solve() {
		
		int[] type = new int[d+1];
		int count=1;
		
		for(int i=0;i<k;i++) {
			if(sushi[i]==c) continue;
			type[sushi[i]] ++;
			if(type[sushi[i]]==1) count++;
		}

		for(int i=k;i<N+k;i++) {
			answer = Integer.max(answer, count);
			type[sushi[i-k]] --;
			if(type[sushi[i-k]]==0) count--;
			if(sushi[i]==c) continue;
			type[sushi[i]] ++;
			if(type[sushi[i]]==1) count++;
		}
		answer = Integer.max(answer, count);
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N+k];
		
		for(int i=0;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		for(int i=N, index=0;i<N+k;i++,index++) {
			sushi[i] = sushi[index];
		}
		
		solve();
		System.out.println(answer);
	}
}
