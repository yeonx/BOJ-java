package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_14890_경사로 {
	
	static int N,L;
	
	static int[][] map;
	static int answer;
	
	static void check() {

		//세로 체크
		for(int i=0;i<N;i++) {
			int stand = map[i][0];
			int count=0;
			boolean isAnswer = true;
			boolean mustCheck = false;
			for(int j=0;j<N;j++) {
				if(mustCheck && count==L) {
					mustCheck = false;
					count=0;
				}
				if(stand==map[i][j]) {
					count++;
				} else if(stand+1 == map[i][j]) { //다음이 더 큼
					if(count<L) {
						isAnswer = false;
						break;
					}
					mustCheck = false;
					stand = map[i][j];
					count=1;
				} else if(stand==map[i][j]+1) {
					if(mustCheck && count<L) isAnswer = false;
					stand = map[i][j];
					count=1;
					mustCheck = true;
				} else {
					isAnswer = false;
					break;
				}
			}
			if(mustCheck && count<L) isAnswer = false;
			if(isAnswer) {
				answer++;
				
			}
			
		}

		//세로 체크
		for(int j=0;j<N;j++) {
			int stand = map[0][j];
			int count=1;
			boolean isAnswer = true;
			boolean mustCheck = false;
			for(int i=1;i<N;i++) {
				if(mustCheck && count==L) {
					mustCheck = false;
					count=0;
				}
				if(stand==map[i][j]) {
					count++;
				} else if(stand+1 == map[i][j]) { //다음이 더 큼
					if(count<L) {
						isAnswer = false;
						break;
					}
					mustCheck = false;
					stand = map[i][j];
					count=1;
				} else if(stand==map[i][j]+1) {
					if(mustCheck && count<L) isAnswer = false;
					stand = map[i][j];
					count=1;
					mustCheck = true;
				} else {
					isAnswer = false;
					break;
				}
			}
			if(mustCheck && count<L) isAnswer = false;
			if(isAnswer) {
				answer++;
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check();
		System.out.println(answer);
		
	}

}
