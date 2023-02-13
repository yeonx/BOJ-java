package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21318 {

	static int N,Q;
	static int[] music;
	static int[] count;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		music = new int[N+1];
		count = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			music[i] = Integer.parseInt(st.nextToken());
			if(music[i] < music[i-1]) {
				count[i] = count[i-1]+1;
			}else {
				count[i] = count[i-1];
			}
		}

		Q = Integer.parseInt(br.readLine());
	
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			sb.append(count[y]-count[x]).append("\n");
		}
		System.out.println(sb);
	}
}
