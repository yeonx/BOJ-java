package day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_2206_벽부수고이동하기 {
	
	static int N, M;
	
	static int[][] map;
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	
	static boolean[][][] vis;
	
	static int answer = -1;
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,0,1});
		
		vis[0][0][0] = true;
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			
			int y = polled[0];
			int x = polled[1];
			
//			vis[y][x][polled[2]] = true;
			
			if(y==N-1 && x==M-1) {
				answer = polled[3];
				return;
			}
			
			for(int d=0;d<4;d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(0<=ny && ny<N && 0<=nx && nx<M && !vis[ny][nx][polled[2]]) {
					if(map[ny][nx]==1 && polled[2]==0) {
						q.offer(new int[] {ny, nx, 1, polled[3]+1});
						vis[ny][nx][1] = true;
					}else if(map[ny][nx]==0) {
						q.offer(new int[] {ny, nx, polled[2], polled[3]+1});
						vis[ny][nx][polled[2]] = true;
					}
				}
			}
		}
	}

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		vis = new boolean[N][M][2];
		
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
