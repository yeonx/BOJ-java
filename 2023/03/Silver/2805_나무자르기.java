import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {

    static int N,M;
    static long[] trees,diff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new long[N];
        diff = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        for(int i=N-1;i>0;i--){
            diff[i]  = trees[i] - trees[i-1];
            diff[i]  =  diff[i] * (N - i);
        }
        diff[0] = trees[0] * (N);
        long sum=0;
        long answer=0;
        for(int i=N-1;i>=0;i--){
            sum+=diff[i];
            if(sum==M && i!=0) {
                answer = trees[i-1];
                break;
            }
            else if(sum>M){
                sum -= diff[i];
                for(int j=1;;j++){
                    sum += (N-i);
                    if(sum>=M){
                        answer = trees[i] - j;
                        break;
                    }
                }
                break;
            }
            if(answer!=0) break;
        }

        System.out.println(answer);

    }
}
