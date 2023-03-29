package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		int[][] map = new int[city+1][city+1];
		
		for(int i=1;i<=city;i++) {
			for(int j=1;j<=city;j++) {
				if(i==j) map[i][j]=0;
				else map[i][j] = 100000;
			}
		}
		
		for(int i=0;i<bus;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[start][end] = Integer.min(map[start][end], cost);

		}
		
		for(int k=1;k<=city;k++) {
			for(int i=1;i<=city;i++) {
				for(int j=1;j<=city;j++) {
					map[i][j] = Integer.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for(int i=1;i<=city;i++) {
			for(int j=1;j<=city;j++) {
				sb.append(map[i][j] + " ");
				
			}
			sb.append("\n");
		}
		
		
		
		System.out.println(sb);
	}
}
