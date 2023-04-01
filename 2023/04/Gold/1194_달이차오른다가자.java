import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1194 {
    static int H,W;
    static int[] dy = {0,0,1,-1}, dx = {1,-1,0,0};
    static boolean[] key = new boolean[6];
    static char[][] map;
    static int answer = -1;

    static int currentY, currentX;
    static boolean[][][][][][][][] vis;


    static void bfs(){

        vis = new boolean[H][W][2][2][2][2][2][2];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {currentY, currentX,0,0,0,0,0,0,0});
        vis[currentY][currentX][0][0][0][0][0][0] = true;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            int y = polled[0];
            int x = polled[1];
            int count = polled[2];
            int a = polled[3];
            int b = polled[4];
            int c = polled[5];
            int d = polled[6];
            int e = polled[7];
            int f = polled[8];


            for(int dd=0;dd<4;dd++){
                int ny = dy[dd] + y;
                int nx = dx[dd] + x;
                if(0<=ny&&ny<H&&0<=nx&&nx<W&&map[ny][nx]!='#'&&!vis[ny][nx][a][b][c][d][e][f]){

                    if(map[ny][nx]=='1'){
                        answer = count+1;
                        return;
                    } else if(map[ny][nx]=='a'){
                        q.offer(new int[] {ny,nx,count+1,1,b,c,d,e,f});
                    } else if(map[ny][nx]=='b'){
                        q.offer(new int[] {ny,nx,count+1,a,1,c,d,e,f});
                    } else if(map[ny][nx]=='c'){
                        q.offer(new int[] {ny,nx,count+1,a,b,1,d,e,f});
                    } else if(map[ny][nx]=='d'){
                        q.offer(new int[] {ny,nx,count+1,a,b,c,1,e,f});
                    } else if(map[ny][nx]=='e'){
                        q.offer(new int[] {ny,nx,count+1,a,b,c,d,1,f});
                    } else if(map[ny][nx]=='f'){
                        q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,1});
                    } else if(map[ny][nx]=='A'){
                        if(a==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else if(map[ny][nx]=='B'){
                        if(b==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else if(map[ny][nx]=='C'){
                        if(c==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else if(map[ny][nx]=='D'){
                        if(d==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else if(map[ny][nx]=='E'){
                        if(e==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else if(map[ny][nx]=='F'){
                        if(f==1) q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    } else{
                        q.offer(new int[] {ny,nx,count+1,a,b,c,d,e,f});
                    }
                    vis[ny][nx][a][b][c][d][e][f] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        for(int i=0;i<H;i++){
            String str = br.readLine();
            for(int j=0;j<W;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='0'){
                    currentY = i;
                    currentX = j;
                    map[i][j] = '.';
                }
            }
        }

        bfs();
        System.out.println(answer);

    }
}
