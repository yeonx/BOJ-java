import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int N,M;
    static int[] arr;
    static int[] sub;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        sub = new int[N-1];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N-1;i++){
            sub[i] = Math.abs(arr[i]-arr[i+1]);
        }
        Arrays.sort(sub);

        for(int i=0;i<N-M;i++){
            answer+=sub[i];
        }

        System.out.println(answer);
    }

}
