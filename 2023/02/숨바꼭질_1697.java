package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1697 {
	
	static int N,K;
	static int answer=0;
	static boolean visited[] = new boolean[100001];
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {N,0});
		visited[N] = true;

		while(!q.isEmpty()) {
			if(answer!=0) return;
			
			int[] point = q.poll();
			int count = point[1];
			
			if(point[0] == K) {
				answer = count;
				return;
			}
			
			int[] a = new int[3];
			
			a[0] = point[0]-1;
			a[1] = point[0]+1;
			a[2] = 2*point[0];
			
			for(int i=0;i<3;i++) {
				if(0<=a[i] && a[i]<=100000 && !visited[a[i]]) {
					visited[a[i]] = true;
					q.offer(new int[] {a[i],count+1});			
				}
			}

		}
		
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
	
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs();
        
        System.out.println(answer);
	}

}
