import java.io.*;
import java.util.*;

public class Main_4485 {

    static int N;
    static int[][] map, money;
    static boolean[][] vis;
    static int answer;

    static int[] dy = {0,0,-1,1}, dx = {-1,1,0,0};

    static void dijk(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {return o1[2] - o2[2];});
        pq.offer(new int[] {0,0,map[0][0]});
        money[0][0] = map[0][0];

        while (!pq.isEmpty()){
            int[] polled = pq.poll();
            int y = polled[0];
            int x = polled[1];
            int v = polled[2];

            if(y == N-1 && x == N-1){
                answer = v;
                return;
            }

            if(vis[y][x]) continue;
            vis[y][x] = true;

            for(int d=0;d<4;d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(0<=ny&&ny<N&&0<=nx&&nx<N&&!vis[ny][nx]){
                    if(money[ny][nx] > map[ny][nx] + v){
                        money[ny][nx] = map[ny][nx] + v;
                        pq.offer(new int[] {ny,nx,money[ny][nx]});
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=1;;t++) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            map = new int[N][N];
            money = new int[N][N];
            vis = new boolean[N][N];

            sb.append("Problem " + t +": ");

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    money[i][j] = Integer.MAX_VALUE;
                }
            }
            dijk();
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
