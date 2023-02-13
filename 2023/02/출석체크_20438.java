package baekjoon;

import java.io.*;
import java.util.*;

public class Main_29438 {
	
	static int N, M, K, Q, S, E;
	static int[] student;
	static boolean[] isSleep;
	static int sleep;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int tmp;

		student = new int[N+3];
		isSleep = new boolean[N+3];
		
		for(int i=3;i<N+3;i++) {
			student[i] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			isSleep[Integer.parseInt(st.nextToken())] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			tmp = Integer.parseInt(st.nextToken());
			for(int j=1;tmp*j<N+3;j++) {
				if(isSleep[tmp])
					break;
				if(!isSleep[tmp * j]) {
					student[tmp * j] = 0;
				}
			}
			
		}
		
		for(int i=1;i<N+3;i++) {
			student[i] += student[i-1];
		}

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			System.out.println(student[E] - student[S-1]);
		}

	}

}
