import java.io.*;
import java.util.*;

public class Main_14502_연구소 {

    static class Point {
        int y;
        int x;
        int num;
        Point(int y, int x, int num){
            this.y = y;
            this.x = x;
            this.num = num;
        }

    }

    static int H,W;
    static int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    static int[][] map, copyMap;
    static List<Point> road = new ArrayList<>();
    static int[] wall = new int[3];
    static int answer = Integer.MIN_VALUE;

    static  boolean[][] vis;

    static void copyMap(){
        for(int i=0;i<H;i++) {
            for (int j = 0; j < W; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    static void comb(int cnt, int start){
        if(cnt==3){
            copyMap();
            vis = new boolean[H][W];
            Point p1 = road.get(wall[0]);
            Point p2 = road.get(wall[1]);
            Point p3 = road.get(wall[2]);
            copyMap[p1.y][p1.x] = 1;
            copyMap[p2.y][p2.x] = 1;
            copyMap[p3.y][p3.x] = 1;
            for(int i=0;i<H;i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j]==2 && !vis[i][j]) bfs(i, j);
                }
            }
            int count=0;
            for(int i=0;i<H;i++) {
                for (int j = 0; j < W; j++) {
                    if(copyMap[i][j]==0) {
                        count++;
                    }
                }
            }
            answer = Integer.max(answer, count);
            return;
        }

        for(int i=start;i<road.size();i++){
            wall[cnt] = i;
            comb(cnt+1,i+1);
        }
    }

    static void bfs(int y, int x){

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {y, x});
        vis[y][x] = true;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            y = polled[0];
            x = polled[1];
            copyMap[y][x]=2;

            for(int d=0;d<4;d++){
                int ny = dy[d] + y;
                int nx = dx[d] + x;
                if(0<=ny&&ny<H&&0<=nx&&nx<W&&(copyMap[ny][nx]==0 || copyMap[ny][nx]==2)&&!vis[ny][nx]){
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
        copyMap = new int[H][W];

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==0) {
                    road.add(new Point(i,j,0));
                }
            }
        }
        comb(0,0);
        System.out.println(answer);
    }
}
