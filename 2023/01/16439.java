import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int pos = input.indexOf(" ");

        int N = Integer.parseInt(input.substring(0,pos));
        int M = Integer.parseInt(input.substring(pos+1));

        int[][] num = new int[N][M];

        int sum;
        int answer = 0;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<M ; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            for(int j=i+1;j<M;j++){
                for(int k=j+1;k<M;k++){
                    sum = 0;
                    for(int l=0 ; l<N ;l++){
                        sum += Math.max(Math.max(num[l][i],num[l][j]),num[l][k]);
                    }
                    if(answer < sum){
                        answer = sum;
                    }

                }
            }
        }

        System.out.println(answer);

    }
}
