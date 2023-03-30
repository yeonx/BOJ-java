package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2239_스도쿠 {
	
	static int[][] map = new int[9][9];
	
	static boolean isSolve(int y, int x) {
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					for(int k=1;k<=9;k++) {
						if(isPossibility(i,j,k)) {
							map[i][j] = k;
							if(!isSolve(i, j)) {
								map[i][j] = 0;
							}else {
								break;
							}
						}
					}
				}
				if(map[i][j]==0) return false;
			}
		}
		
		return true;
		
	}
	
	static boolean isPossibility (int y, int x, int num) {
		
		for(int i=0;i<9;i++) {
			if(map[y][i]==num) return false;
			if(map[i][x]==num) return false;
		}
		
		if(y==0) y=1;
		if(x==0) x=1;
		
		for(int i=(y/3)*3;i<(y/3)*3+3;i++) {
			for(int j=(x/3)*3;j<(x/3)*3+3;j++) {
				if(map[i][j]==num) return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		isSolve(0,0);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
