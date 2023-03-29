package day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_17070_파이프옮기기1_서울_20반_이연희 {
	
	static int N;
	static int[][] map;
	
	static int[] dy = {0,1,1};
	static int[] dx = {1,0,1};
	
	static int status = 0;
	
	static int answer=0;
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,1, status});
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			
			if(polled[0]==N-1 && polled[1] == N-1) {
				answer++;
			}
			
			for(int d=0;d<3;d++) {
				
				if(polled[2]==0 && d==1) continue;
				else if(polled[2]==1 && d==0) continue;
				
				int ny = polled[0] + dy[d];
				int nx = polled[1] + dx[d];
				
				if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx]!=1) {
					if(d==2 && (map[ny-1][nx]==1 || map[ny][nx-1]==1)) continue;
					q.offer(new int[] {ny,nx,d});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(answer);
	}

}
