package day0303;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_서울_20반_이연희 {
	
	static int N;
	static int[][] sea;
	static int sharkSize=2,time,feed;
	static int sharkY,sharkX;
	static boolean[][] vis;
	static boolean isEnd;
	static int[] dy = {-1,0,0,1}, dx = {0,-1,1,0};
	
	static void findFish(int y, int x, int count) {
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a1,a2)-> {
			if(a1[2]==a2[2]) {
				if(a1[0]==a2[0]) return a1[1]-a2[1];
				return a1[0]-a2[0];
			}
			return a1[2]-a2[2];
		});
		q.offer(new int[] {y,x,count});
		boolean[][] vis = new boolean[N][N];
		
		while(!q.isEmpty()) {

			int[] polled = q.poll();
			
			y = polled[0];
			x = polled[1];
			count = polled[2];
			
			if(sea[y][x]!=0 && sea[y][x]<sharkSize) {
				feed++;
				if(feed == sharkSize) {
					sharkSize++;
					feed = 0;
				}
				sea[y][x] = 0;
				sharkY = y;
				sharkX = x;
				time = count;
				return;
			}
			
			for(int d=0;d<4;d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if( 0<=ny&&ny<N&&0<=nx&&nx<N && sea[ny][nx]<=sharkSize && !vis[ny][nx]) {
					q.offer(new int[] {ny,nx,count+1});
					vis[ny][nx] = true;
				}
			}
		}
		
		isEnd=true;
		System.out.println(time);
		
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        sea = new int[N][N];
        vis = new boolean[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		sea[i][j] = Integer.parseInt(st.nextToken());
        		if(sea[i][j]==9){
        			sharkY = i;
        			sharkX = j;
        			sea[i][j]=0;
        		}
        	}
        }
        
        while(!isEnd) {
        	findFish(sharkY, sharkX, time);
        }
	}
}
