package day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기 {
	
	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static List<Point> convenienceStore;//
	static boolean[] vis;
	static int festivalY;
	static int festivalX;
	static boolean isHappy;
	
	static void bfs(int homeY, int homeX) {
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		q.offer(new Point(homeY, homeX));
		boolean[] vis = new boolean[convenienceStore.size()];
		
		while(!q.isEmpty()) {
			Point polled = q.poll();
			int y = polled.y;
			int x = polled.x;
			if (Math.abs(festivalY-y) + Math.abs(festivalX-x) <= 1000) {
				isHappy = true;
				return;
			}
			for(int i=0;i<convenienceStore.size();i++) {
				if(!vis[i] && (Math.abs(convenienceStore.get(i).y-y) + Math.abs(convenienceStore.get(i).x-x) <= 1000)) {
					q.offer(new Point(convenienceStore.get(i).y, convenienceStore.get(i).x));
					vis[i] = true;
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int testCast = 0;testCast<T;testCast++) {
			int N = Integer.parseInt(br.readLine());
			isHappy = false;
			convenienceStore = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int homeY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());

			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				convenienceStore.add(new Point(y,x));
			}
			
			st = new StringTokenizer(br.readLine());
			festivalY = Integer.parseInt(st.nextToken());
			festivalX = Integer.parseInt(st.nextToken());
			
			vis = new boolean[convenienceStore.size()];
			bfs(homeY,homeX);
			
			if(isHappy) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}
}
