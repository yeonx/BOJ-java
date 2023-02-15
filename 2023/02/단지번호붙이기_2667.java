package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_bj_2667_단지번호붙이기_서울_20반_이연희 {

	static int answer,N,count;
	static int[][] arr = new int[100][100];
	static boolean[][] vis;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void dfs(int x, int y) {
		
		if(vis[x][y]) return;
		
		vis[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int tmpX = x + dx[i];
			int tmpY = y + dy[i];

			if( 0<=tmpX && tmpX<N && 0<=tmpY && tmpY<N && !vis[tmpX][tmpY]) {
				if( arr[tmpX][tmpY] == 1 ) { 
					count++;
					dfs(tmpX, tmpY);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


    	N = Integer.parseInt(br.readLine());
    	vis = new boolean[N][N];
    	arr = new int[N][N];
    	
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
//    	int[] answerArr = new int[N*N];
    	
    	answer=0;
    	
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine(),"");
    		String tmp = st.nextToken();
    		for(int j=0;j<N;j++) {
    			arr[i][j] = (int)(tmp.charAt(j)-'0');
    		}
    	}
        
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {

    			if(arr[i][j]==1 && !vis[i][j]) {
    				count=1;
    				answer++;
    				dfs(i, j);
    				pq.offer(count);
    			}
    		}
    	}
    	
  
        
        System.out.println(answer);
        
        while(!pq.isEmpty())
        	System.out.println(pq.poll());
	}
	
}
