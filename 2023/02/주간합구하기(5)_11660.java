import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x1,y1,x2,y2;

        int[][] board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                if(j==0){
                    board[i][j] = Integer.parseInt(st.nextToken());
                    continue;
                }
                board[i][j] = Integer.parseInt(st.nextToken()) + board[i][j-1];
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken()) -1;
            y1 = Integer.parseInt(st.nextToken()) -1;
            x2 = Integer.parseInt(st.nextToken()) -1;
            y2 = Integer.parseInt(st.nextToken()) -1;

            int total = 0;
            if(y1>=1){
                for(int j=x1;j<=x2;j++){
                    total+=(board[j][y2] - board[j][y1-1]);
                }
            }else{
                for(int j=x1;j<=x2;j++){
                    total+=(board[j][y2]);
                }
            }
            sb.append(total).append("\n");
        }
        System.out.print(sb);
    }
}
