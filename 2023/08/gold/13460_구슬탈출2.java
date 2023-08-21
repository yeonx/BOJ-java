package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	
	static int N, M;
	static int[][] map;
	
	static int red_y, red_x;
	static int blue_y, blue_x;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int answer=-1;
	
	static boolean[][][][] vis;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		vis = new boolean[N][M][N][M]; // red, blue
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char tmp = str.charAt(j);
				if(tmp=='#') {
					map[i][j] = -1; //벽
				} else if(tmp=='O'){
					map[i][j] = 1; //구멍
				} else {
					map[i][j] = 0;
					if(tmp=='R') {
						red_y=i;red_x = j;
					} else if(tmp=='B') {
						blue_y=i; blue_x=j;
					}
				}
			}
		}
		vis[red_y][red_x][blue_y][blue_x] = true;
		backTracking(red_y, red_x, blue_y, blue_x, 1);
		System.out.println(answer);
	}
	
	static void backTracking(int red_y, int red_x, int blue_y, int blue_x, int count) {
//		print(red_y, red_x, blue_y, blue_x,count);
		if(count>10) return;
		
		for(int d=0;d<4;d++) {
			int nr_y = red_y + dy[d];
			int nr_x = red_x + dx[d];
			int nb_y = blue_y + dy[d];
			int nb_x = blue_x + dx[d];
			int nextr_y = red_y;
			int nextr_x = red_x;
			int nextb_y = blue_y;
			int nextb_x = blue_x;
			
			boolean canGo = true;
			boolean isGoalR = false, isGoalB = false;

			while(canGo) {
				canGo = false;
//				System.out.println("-------------- : " + nextr_y + " " + nextr_x + " " + + nextb_y + " " + nextb_x );
				if(0<=nr_y&&nr_y<N&&0<=nr_x&&nr_x<M&&map[nr_y][nr_x]!=-1&&!isGoalR &&!(nextb_y==nr_y && nextb_x==nr_x)) {
					if(map[nr_y][nr_x]==1) {
						isGoalR = true;
						nextr_y = nr_y;
						nextr_x = nr_x;
			
					} else {
						nextr_y = nr_y;
						nextr_x = nr_x;
						
						nr_y += dy[d];
						nr_x += dx[d];
					}

					canGo = true;
				}
				if(0<=nb_y&&nb_y<N&&0<=nb_x&&nb_x<M&&map[nb_y][nb_x]!=-1&&!isGoalB&&(!(nb_y==nextr_y && nb_x==nextr_x)||map[nb_y][nb_x]==1)) {
					if(map[nb_y][nb_x]==1) {
						isGoalB = true;
						nextb_y = nb_y;
						nextb_x = nb_x;
					} else {
						nextb_y = nb_y;
						nextb_x = nb_x;
						
						nb_y += dy[d];
						nb_x += dx[d];
					}

					canGo = true;
				}		
			}
			if (isGoalB) continue;
			if(isGoalR ) {
				if(answer==-1) answer = count;
				else answer = Math.min(answer, count);
				return;
			} 
			
			if(!vis[nextr_y][nextr_x][nextb_y][nextb_x]) {
				vis[nextr_y][nextr_x][nextb_y][nextb_x] = true;
				backTracking(nextr_y, nextr_x, nextb_y, nextb_x, count+1);
				vis[nextr_y][nextr_x][nextb_y][nextb_x] = false;
			}
		}
	}
	
	
	static void print(int red_y, int red_x, int blue_y, int blue_x, int count) {
		System.out.println(count + "  :   " + red_y + " " + red_x + " " + blue_y + " " + blue_x);
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i==red_y && j==red_x) System.out.print("R ");
				else if(i==blue_y && j==blue_x) System.out.print("B ");
				else if(map[i][j]==0) System.out.print(". ");
				else if(map[i][j]==-1) System.out.print("# ");
				else if(map[i][j]==1) System.out.print("O ");
			}
			System.out.println();
		}
	}

}
