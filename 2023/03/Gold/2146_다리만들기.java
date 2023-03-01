import java.io.*;
import java.util.*;

public class Main_2146 {

    static int N;
    static int[][] map;
    static boolean[][] vis;
    static boolean[][] visIsland;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;

    static void numberIsland(int y, int x, int index) {
        ArrayDeque<int[]> q= new ArrayDeque<>();
        q.offer(new int[] {y,x});

        visIsland[y][x] = true;

        while(!q.isEmpty()) {

            int[] tmp = q.poll();
            map[tmp[0]][tmp[1]] = index;
            visIsland[tmp[0]][tmp[1]] = true;

            for(int d=0;d<4;d++) {
                int ny = dy[d] + tmp[0];
                int nx = dx[d] + tmp[1];

                if(0<=ny && ny<N && 0<=nx && nx<N) {
                    if(map[ny][nx]==1 && !vis[ny][nx]) {
                        vis[ny][nx]=true;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
        }

    }

    static void bfs(int y, int x) {

        ArrayDeque<int[]> q= new ArrayDeque<>();

        q.offer(new int[] {y,x,0});
        vis = new boolean[N][N];

        vis[y][x]=true;
        int stand = map[y][x];

        while(!q.isEmpty()) {

            int[] tmp = q.poll();
            vis[tmp[0]][tmp[1]] = true;

            for(int d=0;d<4;d++) {
                int ny = dy[d] + tmp[0];
                int nx = dx[d] + tmp[1];

                if(0<=ny && ny<N && 0<=nx && nx<N) {
                    if(map[ny][nx]==0 && !vis[ny][nx]) {
                        q.offer(new int[] {ny,nx,tmp[2]+1});
                        vis[ny][nx] = true;
                    } else if(map[ny][nx]!=0 && map[ny][nx]!=stand) {
                        answer = Math.min(tmp[2], answer);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vis = new boolean[N][N];

        visIsland = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index=1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]==1 && !visIsland[i][j]) {
                    numberIsland(i,j,index);
                    index++;
                }
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j]!=0) {
                    vis = new boolean[N][N];
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
}
