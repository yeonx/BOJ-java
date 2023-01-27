import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, total, count;
    static int[][] tomato;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int day = 0 ;
    static int startI, startJ;

    static void bfs(){
//        queue.add(new int[]{i, j});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k=0; k<4; k++){
                int ii = di[k] + cur[0];
                int jj = dj[k] + cur[1];
                if( 0<=ii&&ii<M&&0<=jj&&jj<N && (tomato[ii][jj]==0 || tomato[ii][jj] >tomato[cur[0]][cur[1]]+1)){
                    tomato[ii][jj] = tomato[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{ii, jj});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomato = new int[M][N];
        total = N*M;
        count = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    queue.add(new int[]{i, j});
                    count++;
                }
                else if (tomato[i][j] == -1) {
                    total--;
                }
            }
        }
        if(total==count)
            System.out.println(0);

        else {
            bfs();
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(tomato[i][j]==0){
                        day = 0;
                        break;
                    }
                    day = Math.max(tomato[i][j], day);
                }
                if(day == 0){
                    break;
                }
            }
            System.out.println(day-1);
        }

    }
}
