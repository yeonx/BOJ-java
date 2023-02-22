package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
	
	static int N, M,K;
	static int[][] map;
	static boolean[][] vis;
	
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void dfs(int y, int x) {
		
		vis[y][x] = true;
		
		for(int d=0;d<4;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(0<=ny && ny<N && 0<=nx && nx <M && !vis[ny][nx] && map[ny][nx]==1) {
				
				dfs(ny,nx);
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			vis = new boolean[N][M];
			
			K = Integer.parseInt(st.nextToken());
			
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
				
			}
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!vis[i][j] && map[i][j]==1) {
						dfs(i,j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}
