package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_4055_탈출 {

	static int N,M;
	static char[][] map;
	
	static int[] dy= {-1,1,0,0}, dx = {0,0,-1,1};
	
	static int S_Y, S_X, D_Y, D_X;
	
	static boolean[][] devilVis;
	static boolean[][] suyeonVis;
	
	static int goSuyeon() {
		suyeonVis = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		ArrayDeque<char[][]> mapQ = new ArrayDeque<>();
		q.offer(new int[] {S_Y, S_X,0});
		suyeonVis[S_Y][S_X] = true;
		mapQ.offer(extensionDevil(map));
		
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			int y = polled[0];
			int x = polled[1];
			int move = polled[2];
			char[][] polledMap = mapQ.poll();
			
			for(int d=0;d<4;d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(0<=ny&&ny<N&&0<=nx&&nx<M&&!suyeonVis[ny][nx]) {
					if(polledMap[ny][nx]=='D') {
						return move+1;
					}
					if(polledMap[ny][nx]=='.') {
						suyeonVis[ny][nx] = true;
						q.offer(new int[] {ny, nx, move+1});
						mapQ.offer(extensionDevil(polledMap));
					}
				}
			}
		}
		return -1;
	}
	
	static char[][] extensionDevil(char[][] inputMap) {
		char[][] tmp = new char[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j] = inputMap[i][j];
			}
		}
		devilVis = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tmp[i][j]=='*' && !devilVis[i][j]) {
					devilVis[i][j]=true;
					for(int d=0;d<4;d++) {
						int ny = i+dy[d];
						int nx = j+dx[d];
						if(0<=ny&&ny<N&&0<=nx&&nx<M&&tmp[ny][nx]=='.' &&!devilVis[ny][nx]) {
							devilVis[ny][nx] = true;
							tmp[ny][nx]='*';
						}
					}
				}
			}
		}
		return tmp;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') {
					S_Y = i;
					S_X = j;
					map[i][j]='.';
				} else if(map[i][j]=='D') {
					D_Y = i;
					D_X = j;
				}
			}
		}
		int answer = goSuyeon();
		sb.append((answer==-1? "KAKTUS":answer) + "\n");
			
		
		System.out.println(sb);
	}
}
