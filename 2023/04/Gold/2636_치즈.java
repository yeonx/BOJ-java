import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈 {
    static int H,W;
    static int[][] map;
    static boolean[][] vis;
    static int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};

    static int answerTime, answerLastNumber,preRemove;

    static void melt(int y, int x){
        answerLastNumber=preRemove;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j]==1) {
                    for(int d=0;d<4;d++){
                        int ny = dy[d] + i;
                        int nx = dx[d] + j;
                        if(0<=ny&&ny<H&&0<=nx&&nx<W&&(map[ny][nx]==-1)){
                            map[i][j]=0;
                            preRemove--;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void checkOut(int y, int x){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {y,x});

        vis = new boolean[H][W];
        vis[y][x] = true;
        map[y][x]=-1;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            y = polled[0];
            x = polled[1];
            for(int d=0;d<4;d++){
                int ny = dy[d] + y;
                int nx = dx[d] + x;
                if(0<=ny&&ny<H&&0<=nx&&nx<W&&!vis[ny][nx]&&(map[ny][nx]==0 || map[ny][nx]==-1)){
                    map[ny][nx]=-1;
                    q.offer(new int[] {ny,nx});
                    vis[ny][nx] = true;
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) preRemove++;
            }
        }

        while (preRemove > 0){
            checkOut(0,0);
            melt(0,0);
            answerTime++;
        }
        System.out.println(answerTime + "\n" + answerLastNumber);

    }
}
