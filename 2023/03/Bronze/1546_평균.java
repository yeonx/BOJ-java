import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        int maxNum = Integer.MIN_VALUE;
        double sum=0.0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, arr[i]);
        }

        for(int i=0;i<N;i++){
            sum += (double) arr[i]/(double) maxNum *100.0;
        }

        System.out.println(sum/N);
    }
}
