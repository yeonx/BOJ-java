package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_2563_색종이_서울_20반_이연희 {

	static int N, answer;
	static boolean[][] vis = new boolean[100][100];
	
	static void solve(int x, int y) {
		
		for(int i=x;i<x+10;i++) {
			for(int j=y;j<y+10;j++) {
				if(!vis[i][j]) {
					answer++;
					vis[i][j] = true;				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        int x,y;
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	
        	solve(x,y);
        }
        System.out.println(answer);
    }
}
