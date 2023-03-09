package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2178 {
	
	static int N,M;
	static int[][] map;
	static int answer;
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	
	static void bfs() {
		boolean[][] vis = new boolean[N][M];
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> {
			return o1[2]-o2[2];
		});
		q.offer(new int[] {0,0,1});
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			int y = polled[0];
			int x = polled[1];
			int count = polled[2];

			if(vis[y][x]) continue;
			vis[y][x] = true;
			
			if(y==N-1&&x==M-1) {
				answer = count;
				return;
			}
			
			for(int d=0;d<4;d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(0<=ny&&ny<N && 0<=nx&&nx<M && map[ny][nx]==1 && !vis[ny][nx]) {
					q.offer(new int[] {ny,nx,count+1});
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
        	String str = br.readLine();
        	for(int j=0;j<M;j++) {
        		map[i][j] = str.charAt(j) - '0';
        	}
        }
        bfs();
        System.out.println(answer);
	}
	
}
