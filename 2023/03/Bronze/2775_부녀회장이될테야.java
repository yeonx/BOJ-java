import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int answer=0;

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k][n];

            for(int j=0;j<k;j++){
                for(int l=0;l<n;l++){
                    if(j==0){
                        apt[j][l] = l+1;
                    } else{
                        apt[j][l]=0;
                        for(int ll=0;ll<=l;ll++){
                            apt[j][l]+=apt[j-1][ll];
                        }
                    }
                }
            }
            answer=0;
            for(int j=0;j<n;j++){
                answer+=apt[k-1][j];
            }
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}
