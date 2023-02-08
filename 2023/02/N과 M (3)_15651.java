import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static int[] b;
    static int N,M,C=0;

    static StringBuilder sb = new StringBuilder();
    static void perm(int cnt){
        if(M == cnt){
            for(int i=0;i<M;i++){
            	sb.append(b[i]+" ");
            }
            sb.append("\n");
            C++;
            return;
        }

        for(int i=0;i<N;i++){
            b[cnt] = arr[i];
            perm(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        b = new int[M];


        for(int i=1;i<=N;i++){
            arr[i-1] = i;
        }

        perm(0);
        System.out.print(sb);
    }
}
