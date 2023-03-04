import java.io.*;
import java.util.*;

public class Main_1 {

    static int answer;
    static int N,K;

    static void comb(int cnt, int start){
        if(cnt==K) {
            answer++;
            return;
        }
        for(int i=start;i<N;i++){
            comb(cnt+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        comb(0,0);
        System.out.println(answer);

    }
}
