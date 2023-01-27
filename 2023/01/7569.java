import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, total, count;
    static int[][][] tomato;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] di = {0, 0, -1, 0, 1, 0};
    static int[] dj = {0, 0, 0, 1, 0, -1};

    static int day = 0 ;

    static void bfs(){
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int k=0; k<6; k++){
                int hh = dh[k] + cur[0];
                int ii = di[k] + cur[1];
                int jj = dj[k] + cur[2];

                if( 0<=hh&&hh<H && 0<=ii&&ii<M&&0<=jj&&jj<N && (tomato[hh][ii][jj]==0 || tomato[hh][ii][jj] >tomato[cur[0]][cur[1]][cur[2]]+1)){
                    tomato[hh][ii][jj] = tomato[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{hh, ii, jj});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][M][N];
        total = N*M*H;
        count = 0;

        for(int h=0;h<H;h++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                        count++;
                    } else if (tomato[h][i][j] == -1) {
                        total--;
                    }
                }
            }
        }
        if(total==count)
            System.out.println(0);

        else {
            bfs();
            for(int h=0;h<H;h++) {
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tomato[h][i][j] == 0) {
                            day = 0;
                            break;
                        }
                        day = Math.max(tomato[h][i][j], day);
                    }
                    if (day == 0) break;
                }
                if (day == 0) break;
            }
            System.out.println(day-1);
        }
    }
}
