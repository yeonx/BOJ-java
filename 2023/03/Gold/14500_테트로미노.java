package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14500 {
	
	static int N,M;
	static int[][] map;
	static int answer;

	static void teri(int y, int x) {
		
		int sum=0;
		// blue 1
		for(int i=y;i<4+y && i<N;i++) sum+=map[i][x];
		answer = Math.max(answer, sum);
		// blue 2
		sum=0;
		for(int i=x;i<4+x && i<M;i++) sum+=map[y][i];
		answer = Math.max(answer, sum);
		
		// yellow
		if(1+y<N && 1+x<M) {
			sum=0;
			for(int i=y;i<2+y;i++) {
				for(int j=x;j<2+x;j++) {
					sum += map[i][j];
				}
			}
			answer = Math.max(answer, sum);
		}

		// orange1
		if(y+2<N && x+1<M) {
			sum=0;
			for(int i=y;i<3+y;i++)
				sum += map[i][x];
			sum += map[y+2][x+1];
			answer = Math.max(answer, sum);
		}
		// orange2
		if(y+1<N && x+2<M) {
			sum=0;
			for(int i=x;i<3+x;i++)
				sum += map[y][i];
			sum += map[y+1][x];
			answer = Math.max(answer, sum);
		}
		
		// orange3
		if(x+1<M&&y+2<N) {
			sum=0;
			sum += map[y][x];
			for(int i=y;i<3+y;i++)
				sum += map[i][x+1];
			answer = Math.max(answer, sum);
		}
		// orange4
		if(x+2<M && y+1<N) {
			sum=0;
			sum += map[y][x+2];
			for(int i=x;i<3+x;i++)
				sum += map[y+1][i];
			answer = Math.max(answer, sum);
		}
		// orange5
		if(y+2<N && x+1<M) {
			sum=0;
			for(int i=y;i<3+y;i++)
				sum += map[i][x+1];
			sum += map[y+2][x];
			answer = Math.max(answer, sum);
		}
		// orange6
		if(y+1<N && x+2<M) {
			sum=0;
			for(int i=x;i<3+x;i++)
				sum += map[y][i];
			sum += map[y+1][x+2];
			answer = Math.max(answer, sum);
		}
		// orange7
		if(x+1<M&&y+2<N) {
			sum=0;
			sum += map[y][x+1];
			for(int i=y;i<3+y;i++)
				sum += map[i][x];
			answer = Math.max(answer, sum);
		}
		// orange8
		if(x+2<M && y+1<N) {
			sum=0;
			sum += map[y][x];
			for(int i=x;i<3+x;i++)
				sum += map[y+1][i];
			answer = Math.max(answer, sum);
		}
		
		// green1
		if(y+2<N && x+1<M) {
			sum=0;
			for(int i=y;i<2+y;i++)
				sum += map[i][x];
			for(int i=y+1;i<3+y;i++)
				sum += map[i][x+1];
			answer = Math.max(answer, sum);
		}
		// green2
		if(y+1<N && x+2<M) {
			sum=0;
			for(int i=x+1;i<3+x;i++)
				sum += map[y][i];
			for(int i=x;i<2+x;i++)
				sum += map[y+1][i];
			answer = Math.max(answer, sum);
		}
		// green3
		if(y+2<N && x+1<M) {
			sum=0;
			for(int i=y;i<2+y;i++)
				sum += map[i][x+1];
			for(int i=y+1;i<3+y;i++)
				sum += map[i][x];
			answer = Math.max(answer, sum);
		}
		// green4
		if(y+1<N && x+2<M) {
			sum=0;
			for(int i=x+1;i<3+x;i++)
				sum += map[y+1][i];
			for(int i=x;i<2+x;i++)
				sum += map[y][i];
			answer = Math.max(answer, sum);
		}

		if(y+1<N && x+2<M) {
			// purple1
			sum=0;
			for(int i=x;i<3+x;i++)
				sum += map[y][i];
			sum += map[y+1][x+1];
			answer = Math.max(answer, sum);
			
			// purple2
			sum=0;
			for(int i=x;i<3+x;i++)
				sum += map[y+1][i];
			sum += map[y][x+1];
			answer = Math.max(answer, sum);
		}
		
		if(y+2<N && x+1<M) {
			// purple3
			sum=0;
			for(int i=y;i<3+y;i++)
				sum += map[i][x];
			sum += map[y+1][x+1];
			answer = Math.max(answer, sum);
			
			// purple4
			sum=0;
			for(int i=y;i<3+y;i++)
				sum += map[i][x+1];
			sum += map[y+1][x];
			answer = Math.max(answer, sum);
		}

		
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map= new int[N][M];
        
        answer = Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		teri(i,j);
        	}
        	
        }
        
        System.out.println(answer);
	}
}
