package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_16234_인구이동_서울_20반_이연희 {
	
	static int N,L,R,sum,count,answer;
	static int[][] ground;
	static boolean[][] visited;
	static int flag;
	
	static ArrayDeque<int[]> vis  = new ArrayDeque<>();
	
	static int[] dx = {-1, 1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void addDay() {
		int p = sum / count;
		flag=0;
		while(!vis.isEmpty()) {
			int[] tmp = vis.poll();
			if(ground[tmp[0]][tmp[1]] != p) flag=1;
			ground[tmp[0]][tmp[1]] = p;
		}
	}
	
	static void bfs(int x, int y) {
		ArrayDeque<int[]> q  = new ArrayDeque<>();
		vis  = new ArrayDeque<>();
		
		q.offer(new int[] {x,y,ground[x][y]});
		vis.offer(new int[] {x,y,ground[x][y]});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			sum += tmp[2];
			count++;
			for(int i=0;i<4;i++) {
				int tmpX = tmp[0] + dx[i];
				int tmpY = tmp[1] + dy[i];
				
				if( 0<= tmpX && tmpX <N && 0<=tmpY && tmpY <N && !visited[tmpX][tmpY]) {
					if(L<= Math.abs(tmp[2] - ground[tmpX][tmpY]) && Math.abs(tmp[2] - ground[tmpX][tmpY]) <=R) {
						q.offer(new int[] {tmpX, tmpY, ground[tmpX][tmpY]});
						vis.offer(new int[] {tmpX, tmpY, ground[tmpX][tmpY]});
						visited[tmpX][tmpY] = true;
					}
				}
			}
		}
		
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		ground = new int[N][N];
		
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		while(true) {
			int flg=0;
			visited = new boolean[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!visited[i][j]) {
						sum=0;
						count=0;
						bfs(i,j);addDay();
						if(flag==1) {
							flg=1;
						}
					}
				}
			}
			if(flg==1) {
				answer++;
			} else {
				break;
			}

		}
		
		System.out.println(answer);
	}

}
