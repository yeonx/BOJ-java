package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100 {
	
	static int N, c, answer=Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] vis;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		vis = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				answer = Math.max(answer, map[i][j]);
			}
		}
		backTracking(map,0);
		System.out.println(answer);
	}
	
	static int[][] moveLeft(int[][] m) {
		int[][] movedMap = new int[N][N];
		for(int i=0;i<N;i++) Arrays.fill(movedMap[i], 0);
		for(int col=0;col<N;col++) {
			int pre=-1;
			int count=0;
			for(int row=0;row<N;row++) {
				if(m[col][row]==0) continue;
				if(pre==m[col][row]) {
					movedMap[col][count]=pre*2;
					answer = Math.max(answer, pre*2);
					pre = -1;
					count++;
					continue;
				} else if(pre!=-1) {
					movedMap[col][count]=pre;
					count++;
				} 
				pre = m[col][row];
			}
			if(pre!=-1)
				movedMap[col][count]=pre;
		}
		return movedMap;
	}
	
	static int[][] moveUp(int[][] m) {
		int[][] movedMap = new int[N][N];
		for(int i=0;i<N;i++) Arrays.fill(movedMap[i], 0);
		for(int row=0;row<N;row++) {
			int pre=-1;
			int count=0;
			for(int col=0;col<N;col++) {
				if(m[col][row]==0) continue;
				if(pre==m[col][row]) {
					movedMap[count][row]=pre*2;
					answer = Math.max(answer, pre*2);
					pre = -1;
					count++;
					continue;
				} else if(pre!=-1) {
					movedMap[count][row]=pre;
					count++;
				} 
				pre = m[col][row];
			}
			if(pre!=-1)
				movedMap[count][row]=pre;
		}
		return movedMap;
	}
	
	static int[][] moveRight(int[][] m) {
		int[][] movedMap = new int[N][N];
		for(int i=0;i<N;i++) Arrays.fill(movedMap[i], 0);
		for(int col=0;col<N;col++) {
			int pre=-1;
			int count=N-1;
			for(int row=N-1;row>=0;row--) {
				if(m[col][row]==0) continue;
				if(pre==m[col][row]) {
					movedMap[col][count]=pre*2;
					answer = Math.max(answer, pre*2);
					pre = -1;
					count--;
					continue;
				} else if(pre!=-1) {
					movedMap[col][count]=pre;
					count--;
				} 
				pre = m[col][row];
			}
			if(pre!=-1)
				movedMap[col][count]=pre;
		}
		return movedMap;
	}
	
	static int[][] moveDown(int[][] m) {
		int[][] movedMap = new int[N][N];
		for(int i=0;i<N;i++) Arrays.fill(movedMap[i], 0);
		for(int row=0;row<N;row++) {
			int pre=-1;
			int count=N-1;
			for(int col=N-1;col>=0;col--) {
				if(m[col][row]==0) continue;
				if(pre==m[col][row]) {
					movedMap[count][row]=pre*2;
					answer = Math.max(answer, pre*2);
					pre = -1;
					count--;
					continue;
				} else if(pre!=-1) {
					movedMap[count][row]=pre;
					count--;
				} 
				pre = m[col][row];
			}
			if(pre!=-1)
				movedMap[count][row]=pre;
		}
		return movedMap;
	}
	
	static void backTracking(int[][] preMap, int moveCnt) {

		if(moveCnt==5) return;

		int[][] tmp = moveUp(preMap);

		backTracking(tmp, moveCnt+1);

		tmp = moveDown(preMap);
		backTracking(tmp, moveCnt+1);

		tmp = moveLeft(preMap);
		backTracking(tmp, moveCnt+1);

		tmp = moveRight(preMap);
		backTracking(tmp, moveCnt+1);
		

	}

}
