import java.io.*;
import java.util.*;

public class Main_1929 {
    static int M, N;
    static boolean[] Answer;
    static StringBuilder sb = new StringBuilder();

    static void fraction(){

        for(int i=2;i<=Math.sqrt(N);i++){
            if (Answer[i]) continue;
            for(int j=i*i;j<=N;j+=i){
                Answer[j] = true;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Answer = new boolean[N+1];

        Answer[0] = true;
        Answer[1] = true;

        fraction();

        for(int i = M ; i<=N;i++){
            if(!Answer[i]) sb.append(i + "\n");
        }
        System.out.print(sb);

    }
}
