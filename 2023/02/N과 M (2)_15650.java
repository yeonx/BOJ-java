package day0208;

import java.util.*;
import java.io.*;

public class Main_bj_15650_N과M2_서울_20반_이연희 {

    static int[] arr;
    static int[] b;
    static boolean[] vis;
    static int N,M,C=0;

    static StringBuilder sb = new StringBuilder();
    
    static void perm(int cnt, int start){
        if(M == cnt){
            for(int i=0;i<M;i++){
            	sb.append(b[i]+" ");
            }
            sb.append("\n");
            C++;
            return;
        }

        for(int i=start;i<N;i++){
            if(vis[i]) continue;
            vis[i] = true;
            b[cnt] = arr[i];
            perm(cnt+1,i+1);
            vis[i] = false;
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

        perm(0,0);
        System.out.print(sb);
    }
}
