package day0405;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2 {
	
	static final int INF = 1000000;
	
	static int N,M;
	static int[][] map;
	static boolean[][] islandVis;
	
	static int[] dy= {1,-1,0,0},dx= {0,0,-1,1};
	static int islandNumber = 0;
	
	static int answer = 0;
	static int[][] dist;
	
	static void checkIsland(int y, int x) {
		islandNumber++;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {y,x});
		islandVis[y][x] = true;
		map[y][x] = islandNumber;
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			y = polled[0];
			x = polled[1];
			
			for(int d=0;d<4;d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!islandVis[ny][nx]&&map[ny][nx]==1) {
					q.offer(new int[] {ny,nx});
					islandVis[ny][nx] = true;
					map[ny][nx] = islandNumber;
				}
			}
		}

	}
	
	static void dfs(int y, int x, int num) {
		for(int d=0;d<4;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			int count=0;
			while(0<=ny&&ny<N&&0<=nx&&nx<M) {
				if(map[ny][nx]==0) {
					count++;
				} else if(map[ny][nx]!=num) {
					if(count<2) break;
					dist[num][map[ny][nx]] = Integer.min(dist[num][map[ny][nx]], count);
					dist[map[ny][nx]][num] = dist[num][map[ny][nx]];
					break;
				} else {
					count=0;
				}
				ny += dy[d];
				nx += dx[d];
			}
		}
	}
	
	static boolean[] bfsVis;
	static void bfs() {
		int[] realDist = new int[islandNumber+1];
		Arrays.fill(realDist, INF);
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
		q.offer(new int[] {1,0});
		bfsVis = new boolean[islandNumber+1];
		realDist[1] = 0;
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			int num = polled[0];
			if(bfsVis[num]) continue;
			bfsVis[num] = true;

			for(int i=1;i<=islandNumber;i++) {
				if(dist[num][i]!=INF && !bfsVis[i] && realDist[i] > dist[num][i]) {
					realDist[i] = dist[num][i];
					q.offer(new int[] {i,realDist[i]});
				}
			}
		}
		answer=0;
		for(int i=1;i<=islandNumber;i++) {
			if(realDist[i]==INF) {
				answer=-1;
				return;
			}
			answer+=realDist[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		islandVis = new boolean[N][M];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && !islandVis[i][j]) checkIsland(i,j);
			}
		}
		
		dist = new int[islandNumber+1][islandNumber+1];
		for(int j=1;j<=islandNumber;j++) {
			Arrays.fill(dist[j], INF);			
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0) {
					dfs(i,j,map[i][j]);
				}
			}
		}
		 bfs();
		System.out.println(answer);
	}
}
