package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_1260_DFS와BFS_서울_20반_이연희 {
	
	static int N, M, V;
	static List<Integer>[] graph;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start, end;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new List[N+1];
        
        for(int i=1;i<=N;i++) {
        	graph[i] = new ArrayList<>();
        }
        
        vis = new boolean[N+1];
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	start = Integer.parseInt(st.nextToken());
        	end = Integer.parseInt(st.nextToken());
        	
        	graph[start].add(end);
        	graph[end].add(start);
        }
        
        for(int i=1;i<=N;i++) {
        	if(graph[i].size()>0)	
        		Collections.sort(graph[i]);
        }
        
        DFS(V);
        vis = new boolean[N+1];
        sb.append("\n");
        BFS(V);
        System.out.println(sb);
        
	}
	
	static void BFS(int start) {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		vis[start] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			for(int j:graph[tmp]) {
				if(!vis[j]) {
					vis[j] = true;
					q.offer(j);
				}
			}
			if(!vis[tmp]) {
				vis[tmp] = true;
				q.offer(tmp);
			}
			
			
		}
	}
	
	static void DFS(int start) {
		
		if(vis[start]) return;
		
		vis[start] = true;
		sb.append(start + " ");
		
		for(int j: graph[start]) {
			if(!vis[j]) {
				DFS(j);
			}
		}
	}
}
