package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		int[][] dp = new int[N+1][K+1];
		
		for(int i=0;i<N;i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
			
			for(int j=1;j<=K;j++) {
				dp[i][j] = dp[i-1][j];
				if(j >= weight[i]) {
					dp[i][j] = Integer.max(dp[i][j], dp[i-1][j-weight[i]] + value[i]);
				} 
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	}

}
