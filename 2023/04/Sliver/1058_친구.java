package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1058_친구 {
	
	
	static final int INF = 9999999;
	static int N,distance[][];
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		distance = new int[N][N];
	
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char tmp = str.charAt(j);
				if(i != j && tmp=='N') {
					distance[i][j]=INF;
				} else if(i == j &&tmp=='N') {
					distance[i][j]=0;
				} else {
					distance[i][j]=1;
				}
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int count=0;
			for(int j=0; j<N; j++) {
				if((distance[i][j]==1 ||distance[i][j]==2)  && i!=j) count++;
			}
			answer = Math.max(answer, count);
		}
		System.out.println(answer);
		
		br.close();
	}

}
