package day0221;

import java.io.*;
import java.util.*;

public class Main_bj_3109_빵집_서울_20반_이연희 {
	
	static int R, C;
	static char[][] map;
	static boolean[][] vis;
	static int answer;
	
	static boolean dfs(int y, int x) {
		map[y][x] = 'x';
		
		if(x == C-1) return true;
		
		if( y > 0 && map[y-1][x+1]=='.') {
			if(dfs(y-1,x+1)) return true;
		}
		if(map[y][x+1]=='.') {
			if(dfs(y,x+1)) return true;
		}
		if(y < R-1 && map[y+1][x+1]=='.') {
			if(dfs(y+1, x+1)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		vis = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for(int j=0;j<C;j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			if(dfs(i,0))
				answer++;
		}
		System.out.println(answer);
	}
}
