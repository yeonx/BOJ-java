import java.io.*;
import java.util.*;

public class Main_10830_행렬제곱 {

    static int N;

    static int[][] matrix,answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        answer = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
            answer[i][i] = 1;
        }
        solve(B);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solve(long b){

        while(b>0) {
            if(b%2==1) {
                answer = mul(answer,matrix);
            }
            matrix = mul(matrix, matrix);
            b = b/2;
        }
    }

    static int[][] mul(int[][] m1, int[][] m2){
        int[][] mat = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    mat[i][j] += m1[i][k]*m2[k][j];
                    mat[i][j] = mat[i][j]%1000;
                }
            }
        }
        return mat;
    }
}
