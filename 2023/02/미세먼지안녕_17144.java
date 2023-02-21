package day0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_17144_미세먼지안녕_서울_20반_이연희 {
	
	static int R, C, T;
	static int[][] room;
	static int[][] addDust;
	
	static int[][] airFresh = new int[2][2];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int answer;
	
	static void spread() {
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j] !=0) {
					int count=0;
					for(int d=0; d<4;d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(0<=nx && nx<R && 0<=ny && ny<C && room[nx][ny] != -1) {
							addDust[nx][ny] += room[i][j]/5;
							count++;
						}
					}
					addDust[i][j] -= (room[i][j]/5*count);
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				room[i][j] += addDust[i][j];
			}
		}
	}
	
	static void wind() {
		
		for(int k=airFresh[0][0]-1; k>0; k--)
			room[k][0] = room[k-1][0];
		
		for(int k=0; k<C-1; k++)
			room[0][k] = room[0][k+1];
		
		for(int k=0; k<=airFresh[0][0]-1; k++) {
			room[k][C-1] = room[k+1][C-1];
		}
		
		for(int k=C-1 ; k>=2; k--) {
			room[airFresh[0][0]][k] = room[airFresh[0][0]][k-1];
		}
		room[airFresh[0][0]][1] = 0;
		
		for(int k=airFresh[1][0]+1; k<R-1 ; k++)
			room[k][0] = room[k+1][0];
		
		for(int k=0; k<C-1; k++)
			room[R-1][k] = room[R-1][k+1];

		for(int k=R-1; k>=airFresh[1][0]+1; k--) {
			room[k][C-1] = room[k-1][C-1];
		}
		
		for(int k=C-1 ; k>=2; k--) {
			room[airFresh[1][0]][k] = room[airFresh[1][0]][k-1];
		}
		room[airFresh[1][0]][1] = 0;

	}
	
	static void cal() {
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				answer += room[i][j];
			}
		}

	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		int cnt=0;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					airFresh[cnt][0] = i;
					airFresh[cnt++][1] = j;
				}
			}
		}
		
		for(int i=0;i<T;i++) {
			addDust = new int[R][C];
			spread();
			wind();
		}
		cal();
		System.out.println(answer+2);

	}

}
