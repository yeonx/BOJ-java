package day0223;

import java.io.*;
import java.util.*;

public class Main_bj_17135_캐슬디펜스_서울_20반_이연희 {

    static int N,M,D;
    static int[][] map,copyMap, enemy = new int[3][2];
    static boolean[][] vis,visE;
    static int[] pick = new int[3];
    static int max = Integer.MIN_VALUE;

    static int[] dy = {0, -1, 0};
    static int[] dx = {-1, 0, 1};

    static void down() { //N만큼 내려야함
        for(int i=N-1; i>0;i--) {
            for(int j=M-1; j>=0;j--) {
                copyMap[i][j] = copyMap[i-1][j];
            }
        }
        for(int j=0;j<M;j++)
            copyMap[0][j] =0;
    }
  

    static void copy(){
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }
    static void attack() {

        copy();
        int count=0;

        //공격수 배치
        for(int at = 0; at<3 ; at++) {
            copyMap[N][pick[at]] = 2;
        }

        //공격
        for(int t=0;t<N;t++) {
        	visE = new boolean[N][M];
        	ArrayDeque<int[]> enemy = new ArrayDeque<>();
        	for(int forward : pick) { // 공격수 한 명 씩
        		vis = new boolean[N][M];
        		ArrayDeque<int[]> q = new ArrayDeque<>();
        		int flg=0;
        		int cy = N, cx = forward;
        		q.offer(new int[] {cy, cx});
        		int ny=N, nx = forward;
        		
        			
    			while(!q.isEmpty()) {
    				int[] polled = q.poll();
    				int y = polled[0];
    				int x = polled[1];
    				
    				for(int d = 0; d<3 ; d++) {
        				ny = y + dy[d]; 
        				nx = x + dx[d];
        				
        				if(0<=ny && ny<N && 0<=nx && nx < M && ((Math.abs(ny-cy) + Math.abs(nx-cx)) <= D)){
                            if (copyMap[ny][nx]==1){
                                flg=1;
                            	if(!visE[ny][nx]) {
                            		enemy.add(new int[] {ny, nx});
                            		count++;
                            	}
                            	visE[ny][nx] = true;
                                break;
                            }
                            
                            if(!vis[ny][nx]) {
                            	q.offer(new int[] {ny, nx});
                            	vis[ny][nx] = true;
                            }
                        }
    				}
    				if(flg==1) break;
    				
        		}
        	}
        	for(int[] point : enemy) {
        		copyMap[point[0]][point[1]]=0;
//        		System.out.println(point[0] + " " + point[1]);
        	}
//        	count += enemy.size();
            down();
        }
        
        max = Math.max(max, count);
    }
    static void comb(int cnt, int start) {
        if(cnt == 3) {
            attack();
            return;
        }

        for(int i=start;i<M;i++) {
            pick[cnt] = i;
            comb(cnt+1, i+1);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][M];
        copyMap = new int[N+1][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0,0);

        System.out.println(max);
    }
}
