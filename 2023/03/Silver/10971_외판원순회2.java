package day0329;

import java.io.*;
import java.util.*;

public class Main_10971_외판원순회2 {
	
	static int N;
	
	static List<int[]>[] city;
	
	static int answer = Integer.MAX_VALUE;
	
	static boolean[] vis;

	static void fast(int num, int count, int cost) {
		
		if(count==N && num==1) {
			answer = Integer.min(answer, cost);
			return;
		}
		
		for(int[] nextCity : city[num]) {
			if(!vis[nextCity[0]]) {
				vis[nextCity[0]] = true;
				fast(nextCity[0], count+1, cost + nextCity[1]);
				vis[nextCity[0]] = false;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		city = new List[N+1];
		vis = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			city[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num!=0) city[i].add(new int[] {j, num});
			}
		}
		
		fast(1,0,0);
		
		System.out.println(answer);
		

	}

}
