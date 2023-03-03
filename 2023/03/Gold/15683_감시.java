package day0303;

import java.io.*;
import java.util.*;

public class Main_bj_15683_감시_서울_20반_이연희 {

	static int N,M,answer = Integer.MAX_VALUE;
	
	static int[][] room;
	
	static boolean[][] vis;
	
	static class CCTV {
		int y;
		int x;
		public CCTV(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static List<CCTV> cctv = new ArrayList<>();

	static void initVis() {
		vis = new boolean[N][M];
		for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(room[i][j]!=0) vis[i][j] = true;
        	}
        }
	}
	
	static boolean[][] copyVis(boolean[][] vis) {
		boolean[][] tmp = new boolean[N][M];
		for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		tmp[i][j] = vis[i][j];
        	}
        }
		return tmp;
	}
	
	static void countFalse(boolean[][] vis) {
		int count =0 ;
		for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if(!vis[i][j]) count++;
        	}
        }
		answer = Math.min(answer, count);
		
	}
	
	static boolean[][] upCCTV(int y, int x, boolean[][] vis) {
		for(int i=y-1;i>=0;i--) {
			if(room[i][x]==6) break;
			vis[i][x] = true;
        }
		return vis;
	}
	
	static boolean[][] downCCTV(int y, int x, boolean[][] vis) {
		for(int i=y+1;i<N;i++) {
			if(room[i][x]==6) break;
			vis[i][x] = true;
        }
		return vis;
	}
	
	static boolean[][] leftCCTV(int y, int x, boolean[][] vis) {
		for(int i=x-1;i>=0;i--) {
			if(room[y][i]==6) break;
			vis[y][i] = true;
        }
		return vis;
	}
	
	static boolean[][] rightCCTV(int y, int x, boolean[][] vis) {
		for(int i=x+1;i<M;i++) {
			if(room[y][i]==6) break;
			vis[y][i] = true;
        }
		return vis;
	}

	static void watch(int cnt, boolean[][] vis) {
		if(cnt == cctv.size()) {
			countFalse(vis);
			return;
		}
		initVis();
		CCTV point = cctv.get(cnt);
		int num = room[point.y][point.x];
		boolean[][] tmp;
		if(num==1) {
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, tmp));
			
			tmp = copyVis(vis);
			watch(cnt+1, downCCTV(point.y, point.x, tmp));
			
			tmp = copyVis(vis);
			watch(cnt+1, leftCCTV(point.y, point.x, tmp));
			
			tmp = copyVis(vis);
			watch(cnt+1, rightCCTV(point.y, point.x, tmp));
		} else if (num==2) {
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, downCCTV(point.y, point.x, tmp)));
			
			tmp = copyVis(vis);
			watch(cnt+1, leftCCTV(point.y, point.x, rightCCTV(point.y, point.x, tmp)));
		} else if (num==3) {
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, leftCCTV(point.y, point.x, tmp)));
			
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, rightCCTV(point.y, point.x, tmp)));
			
			tmp = copyVis(vis);
			watch(cnt+1, downCCTV(point.y, point.x, leftCCTV(point.y, point.x, tmp)));
			
			tmp = copyVis(vis);
			watch(cnt+1, downCCTV(point.y, point.x, rightCCTV(point.y, point.x, tmp)));
		} else if (num==4) {
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, leftCCTV(point.y, point.x, rightCCTV(point.y, point.x, tmp))));
			
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, leftCCTV(point.y, point.x, downCCTV(point.y, point.x, tmp))));
			
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, rightCCTV(point.y, point.x, downCCTV(point.y, point.x, tmp))));
			
			tmp = copyVis(vis);
			watch(cnt+1, downCCTV(point.y, point.x, rightCCTV(point.y, point.x, leftCCTV(point.y, point.x, tmp))));
		} else {
			tmp = copyVis(vis);
			watch(cnt+1, upCCTV(point.y, point.x, leftCCTV(point.y, point.x, rightCCTV(point.y, point.x, downCCTV(point.y, point.x, tmp)))));
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        room = new int[N][M];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		room[i][j] = Integer.parseInt(st.nextToken());
        		if(1<=room[i][j] && room[i][j]<6) cctv.add(new CCTV(i,j));
        	}
        }
        initVis();
        watch(0,vis);
        System.out.println(answer);
	}
}
