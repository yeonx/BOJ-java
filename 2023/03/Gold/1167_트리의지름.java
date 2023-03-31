package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1167_트리의지름 {
static List<int[]>[] node;
	
	static int N, answer = 0;
	
	static boolean[] isRoot;
	static boolean[] vis;
	static int maxNodeNum;
	
	static void dfs(int stand, int weight) {
		vis[stand] = true;
		
		
		for(int[] tmp : node[stand]) {
			if(!vis[tmp[0]]) {
				if(answer <tmp[1] + weight ) {
					maxNodeNum= tmp[0];
					answer = Integer.max(answer, tmp[1] + weight);
				}
				dfs(tmp[0], tmp[1] + weight);
			}
		}
	}
	
	static void dfsLast(int stand, int weight) {
		vis[stand] = true;
//		maxNodeNum= stand;
		
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
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int standNode = Integer.parseInt(st.nextToken());
			int count=0;
			while(true) {
				int nextNode = Integer.parseInt(st.nextToken());
				if(nextNode==-1) break;
				count++;
				int weight = Integer.parseInt(st.nextToken());
				node[standNode].add(new int[] {nextNode, weight});
			
			}
			if(count>1)
				isRoot[standNode] = true;

		}
		
		for(int i=1;i<=N;i++) {
			if(!isRoot[i]) {
				vis = new boolean[N+1];
				dfs(i,0);
				break;
			}
		}

		vis = new boolean[N+1];
		dfsLast(maxNodeNum,0);
		
		System.out.println(answer);
	}
}
