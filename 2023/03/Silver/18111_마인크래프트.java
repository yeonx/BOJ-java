package baekjoon;

import java.io.*;
import java.util.*;

public class Main_18111_마인크래프트 {
	
	static int N,M;
	static int minHeight = Integer.MAX_VALUE,maxHeight = Integer.MIN_VALUE;
	static int B;
	static int[][] map;
	
	static int answerTime = Integer.MAX_VALUE, answerHeight;
	
	static void even(int stand) {

		int currentB = B;
		int time=0;
		int[][] copyMap = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(stand < copyMap[i][j]) {
					currentB += (copyMap[i][j] - stand);
					time = time + 2*(copyMap[i][j] - stand);
//					copyMap[i][j] = stand;
				} else {
					if(stand > copyMap[i][j]) {
						currentB -= (stand-copyMap[i][j]);
						time += (stand-copyMap[i][j]);
//						copyMap[i][j] = stand;
					}
				}
			}
		}
		
		if(currentB>=0) {
			if(answerTime > time) {
				answerHeight = stand;
				answerTime = time;
				
			} else if(answerTime == time) {
				if(answerHeight < stand) answerHeight = stand;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) maxHeight = map[i][j];
				if(map[i][j] < minHeight) minHeight = map[i][j];
			}
		}
		
		for(int i=minHeight;i<=maxHeight;i++) {
			even(i);
		}

		System.out.println(answerTime + " " + answerHeight);
	
	}

}
