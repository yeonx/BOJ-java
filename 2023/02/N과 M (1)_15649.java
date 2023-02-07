import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] b;
    static boolean[] vis;
    static int N,M,C=0;

    static void perm(int cnt){
        if(M == cnt){
            for(int i=0;i<M;i++){
                System.out.print(b[i]+" ");
            }
            System.out.println();
            C++;
            return;
        }

        for(int i=0;i<N;i++){
            if(vis[i]) continue;
            vis[i] = true;
            b[cnt] = arr[i];
            perm(cnt+1);
            b[cnt] = 0;
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

        perm(0);
    }
}
