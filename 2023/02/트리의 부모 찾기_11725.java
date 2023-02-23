package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725 {
	
	static List<Integer>[] graph;
	static boolean[] vis;
	static int[] parent;
	
	static void BFS(int start) {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		vis[start] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int j:graph[tmp]) {
				if(!vis[j]) {
					vis[j] = true;
					q.offer(j);
					parent[j] = tmp;
				}
			}
			if(!vis[tmp]) {
				vis[tmp] = true;
				q.offer(tmp);
			}
			
			
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(br.readLine());
        
        graph = new List[num+1];
        vis = new boolean[num+1];
        parent = new int[num+1];
        
        for(int i=1;i<=num;i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i=1;i<num;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph[a].add(b);
        	graph[b].add(a);
        }
        
        BFS(1);
        
        for(int i=2;i<=num;i++) {
        	System.out.println(parent[i]);
        }
	
	}

}
