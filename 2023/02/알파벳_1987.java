package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_1987_알파벳_서울_20반_이연희 {

	static int R, C;
	static boolean Alph[] = new boolean[26];
	static char[][] board;
	
	static int answer;
	static boolean[][] vis;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void DFS(int y, int x, int cnt) {
	
		
		for(int d=0;d<4;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(0<=ny && ny<R && 0<= nx && nx<C) {
				if(!Alph[board[ny][nx] - 'A']) {
					Alph[board[ny][nx] - 'A'] = true;
					DFS(ny,nx,cnt+1);
					Alph[board[ny][nx] - 'A'] = false;
				}
			}
		}
		
		if(answer < cnt) {
			answer = cnt;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        
        for(int i=0;i<R;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<C;j++) {
        		board[i][j] = tmp.charAt(j);
        	}
        }

        Alph[board[0][0] - 'A'] = true;
        DFS(0,0,1);
        System.out.println(answer);
	}
}
