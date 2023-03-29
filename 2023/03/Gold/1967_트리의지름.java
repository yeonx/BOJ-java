package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1967_트리의지름 {
	
	static List<int[]>[] node;
	
	static int N, answer = 0;
	
	static boolean[] isRoot;
	static boolean[] vis;
	
	static void dfs(int stand, int weight) {
		vis[stand] = true;
		
		for(int[] tmp : node[stand]) {
			if(!vis[tmp[0]]) {
				answer = Integer.max(answer, tmp[1] + weight);
				dfs(tmp[0], tmp[1] + weight);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		node = new List[N+1];
		
		isRoot = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			node[i] = new ArrayList<>();  
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			
			int nodeNum1 = Integer.parseInt(st.nextToken());
			int nodeNum2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			isRoot[nodeNum1] = true;
			node[nodeNum1].add(new int[] {nodeNum2, weight});
			node[nodeNum2].add(new int[] {nodeNum1, weight});
		}
		
		for(int i=1;i<=N;i++) {
			if(!isRoot[i]) {
				vis = new boolean[N+1];
				dfs(i,0);
			}
		}
		
		System.out.println(answer);
	}
}
