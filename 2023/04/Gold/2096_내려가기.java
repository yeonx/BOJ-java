import java.io.*;
import java.util.*;

public class Main_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if(i==0){
                maxDP[0] = x1;
                maxDP[1] = x2;
                maxDP[2] = x3;

                minDP[0] = x1;
                minDP[1] = x2;
                minDP[2] = x3;
            } else {
                int before0 = maxDP[0], before2 = maxDP[2];
                maxDP[0] = Math.max(before0,maxDP[1]) + x1;
                maxDP[2] = Math.max(before2,maxDP[1]) + x3;
                maxDP[1] = Math.max(Math.max(before0,maxDP[1]), before2) + x2;

                before0 = minDP[0]; before2 = minDP[2];
                minDP[0] = Math.min(before0,minDP[1]) + x1;
                minDP[2] = Math.min(before2,minDP[1]) + x3;
                minDP[1] = Math.min(Math.min(before0,minDP[1]), before2) + x2;
            }

        }

        int maxAnswer = Math.max(Math.max(maxDP[0],maxDP[1]), maxDP[2]);
        int minAnswer = Math.min(Math.min(minDP[0],minDP[1]), minDP[2]);

        System.out.println(maxAnswer + " " + minAnswer);
    }
}
