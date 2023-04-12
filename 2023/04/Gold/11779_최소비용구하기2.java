package day0412;

import java.io.*;
import java.util.*;

public class Main_bj_11779_최소비용구하기2 {

	
	static int n, m;
	
	static List<int[]>[] city;
	static int[] dist;
	static int[] preCity;
	
	static int start,end;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	
	static int[] cityList;
	
	static void solve() {
		dist[start] = 0;
		preCity[start] = start;
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
		
		q.offer(new int[] {start, dist[start], 1, start});

		while(!q.isEmpty()) {
			int[] polled = q.poll();
			int point = polled[0];
			int cost = polled[1];
			int count = polled[2];
			int pre = polled[3];
			
			
			
			if(vis[point]) continue;
			vis[point] = true;
			
			preCity[point] = pre;
			
			if(point==end) {
				sb.append(cost + "\n");
				sb.append(count + "\n");
				cityList = new int[count];
				
				int tmp = point;
				for(int i=count-1;i>=0;i--) {
					cityList[i] = tmp;
					tmp = preCity[tmp];
				}
				
				for(int i=0;i<count;i++) {
					sb.append(cityList[i] + " ");
				}
				return;
			}
			
			for(int[] c : city[point]) {
				int nextCity = c[0];
				int nextCityCost = c[1];
				if(!vis[nextCity] && dist[nextCity] > cost + nextCityCost) {
					dist[nextCity] = cost + nextCityCost;
					q.offer(new int[] {nextCity, dist[nextCity], count+1, point});
				}
				
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		city = new List[n+1];
		dist = new int[n+1];
		preCity = new int[n+1];
		vis = new boolean[n+1];
		
		for(int i=1;i<=n;i++) city[i] = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			city[p1].add(new int[] {p2, cost});
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		solve();
		
		System.out.println(sb);

	}

}
