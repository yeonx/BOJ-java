import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	static int[][] map;
	static boolean[][] vis;
	
	static int[] dx = new int[] {-1,1,0,0,-1,-1,1,1};
	static int[] dy = new int[] {0,0,-1,1,-1,1,-1,1};
	
	static void dfs(int y, int x) {
		
		vis[y][x] = true;
		
		for(int d=0;d<8;d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(0<=ny && ny<h && 0<=nx && nx<w && !vis[ny][nx]) {
				if(map[ny][nx]==1) {
					dfs(ny,nx);
				}
			}
			
		}
	}
	
	static void bfs(int y, int x) {
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		vis[y][x] = true;
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			
			int[] tmp = q.poll();
			y = tmp[0];
			x = tmp[1];
		
			for(int d=0;d<8;d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(0<=ny && ny<h && 0<=nx && nx<w && !vis[ny][nx]) {
					if(map[ny][nx]==1) {
						q.offer(new int[] {ny, nx});
						vis[ny][nx] = true;
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int answer=0;
		
		while(true) {
			st = new StringTokenizer(br.readLine()); 
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			
			map = new int[h][w];
			vis = new boolean[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!vis[i][j] && map[i][j]==1) {
//						dfs(i,j);
						bfs(i,j);
						answer++;
					}
				}
			}
			System.out.println(answer);
			
			
		}
	
	}

}
