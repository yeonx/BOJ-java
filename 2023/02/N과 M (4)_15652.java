package day0208;

import java.util.*;
import java.io.*;

public class Main_bj_15652_N과M4_서울_20반_이연희 {

    static int[] arr;
    static int[] b;
    static boolean[] vis;
    static int N,M,C=0;

    static StringBuilder sb = new StringBuilder();
   
    static void comb(int cnt, int start) { // 왜 더 받냐면
		if(cnt == M) {
			for(int i=0;i<M;i++){
            	sb.append(b[i]+" ");
            }
            sb.append("\n");
            C++;
            return;
		}
		for(int i=start;i<N;i++) {
			b[cnt] = arr[i];
//			comb(cnt+1, i + 1 ); // 조합
			comb(cnt+1, i ); // 중복조합
		}
	}
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        vis = new boolean[N];
        
        b = new int[M];


        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }

        comb(0,0);
        System.out.print(sb);
    }
}
