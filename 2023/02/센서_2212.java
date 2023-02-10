import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum=0;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int[] diff = new int[N-1];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<N-1;i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        for(int i=0;i<N-K;i++){
            sum+=diff[i];
        }

        System.out.println(sum);

    }

}
