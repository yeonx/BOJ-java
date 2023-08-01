package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049 {
	
	static int N;
	
	static int[][] map, num;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		num = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			num[i][0] = n1;
			num[i][1] = n2;
		}
		
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				int x = i + j;
				map[j][x] = Integer.MAX_VALUE;
				for(int k=j;k<x;k++) {
					map[j][x] = Math.min(map[j][x], map[j][k] + map[k+1][x] + num[j][0]*num[k][1]*num[x][1]);
				}
			}
		}
		
		System.out.println(map[0][N-1]);

	}

}
