import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_2798_블랙잭_서울_20반_이연희 {
	static int[] arr;
    static int[] b;
    static int N,stand;
    static boolean[] vis;
    static int answer=Integer.MAX_VALUE;

    static void perm(int cnt, int start){
    	if(3 == cnt){
        	int total=0;
            for(int i=0;i<3;i++){
            	total+=b[i];
            }
            int tmp = stand - total;
            int tmp2 = answer - stand; 
            if(tmp>=0 && Math.abs(tmp) < Math.abs(tmp2)) {
            	answer = total;
            }
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
        stand = Integer.parseInt(st.nextToken());

        arr = new int[N];
        vis = new boolean[N];
        
        b = new int[3];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            
        }

        perm(0,0);
        System.out.println(answer);
    }

}
