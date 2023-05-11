import java.io.*;
import java.util.*;

public class Main_2166_다각형의면적 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] x = new long[N+1];
        long[] y = new long[N+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];

        long sum=0;
        long diff=0;

        for(int i=0;i<N;i++){
            sum += x[i]*y[i+1];
            diff += x[i+1]*y[i];
        }

        String area = String.format("%.1f", (Math.abs(sum - diff) / 2.0));
        System.out.println(area);

    }
}
