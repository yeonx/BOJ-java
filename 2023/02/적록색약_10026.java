package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_10026_적록색약_서울_20반_이연희 {
	
	static int N;
	static char[][] map;
	static boolean[][] visG, visB;
	static int G, B;
	
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	
	static void blindness(int y, int x) {

		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {y,x});
		visB[y][x] = true;
		char stand = map[y][x];
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ny = tmp[0] + dy[d];
				int nx = tmp[1] + dx[d];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visB[ny][nx]) {
					if(stand == 'B' && stand == map[ny][nx]) {
						visB[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
					else if(stand != 'B' && (map[ny][nx] == 'R' || map[ny][nx] == 'G')) {
						visB[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}
		
	}
	
	static void general(int y, int x) {

		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {y,x});
		visG[y][x] = true;
		char stand = map[y][x];
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d=0;d<4;d++) {
				int ny = tmp[0] + dy[d];
				int nx = tmp[1] + dx[d];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<N&&!visG[ny][nx]) {
					if(stand == map[ny][nx]) {
						visG[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        StringTokenizer st = new StringTokenizer(br.readLine());
	
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visG = new boolean[N][N];
        visB = new boolean[N][N];
        
        for(int i=0;i<N;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<N;j++) {
        		map[i][j] = tmp.charAt(j);
        	}
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(!visG[i][j]) {
        			G++;
        			general(i, j);
        		}
        	}
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(!visB[i][j]) {
        			B++;
        			blindness(i, j);
        		}
        	}
        }
        
        System.out.println(G + " " + B);
	}
}
