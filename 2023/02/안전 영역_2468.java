import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] vis;
	static int T;
	static int N;
	static int maxMass = 1;
	static int day;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static void dfs(int x, int y) {
		
		if(vis[x][y]) return;
		
		vis[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int tmpX = x + dx[i];
			int tmpY = y + dy[i];
	
			if(0<=tmpX && tmpX <N && 0<= tmpY && tmpY<N && !vis[tmpX][tmpY] && map[tmpX][tmpY] > day) {
				dfs(tmpX, tmpY);
			}
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(day = 0 ; day<= 100 ; day++) {
            vis = new boolean[N][N];
            int count = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!vis[i][j] && map[i][j] > day) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            if(count > maxMass) {
                maxMass = count;
            }
        }
			

		System.out.println(maxMass);
	}
}
