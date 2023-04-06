package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_1504_특정한최단경로 {
	
	static int N,E;
	static int v1,v2;
	
	static final long INF = 200000000L;
	
	
	static List<int[]>[] list;

	static long answer=-1;
	static boolean[][][] vis;
	
	static long[][][] dist;

	static void bfs() {
		dist = new long[N+1][2][2];
		for(int i=1;i<=N;i++) {
			for(int j=0;j<2;j++) {
				Arrays.fill(dist[i][j], INF);				
			}
		}
		PriorityQueue<long[]> q = new PriorityQueue<>((o1,o2) -> (int)(o1[1]-o2[1]));
		if(v1==1) {
			q.offer(new long[] {1,0,1,0});
			dist[1][1][0] = 0L;
		} else {			
			q.offer(new long[] {1,0,0,0});
			dist[1][0][0] = 0L;
		}
		
		while(!q.isEmpty()) {
			long[] polled = q.poll();
			int currentNode = (int)polled[0];
			long weight = polled[1];
			int visV1 = (int)polled[2];
			int visV2 = (int)polled[3];
			if(vis[currentNode][visV1][visV2]) continue;
			vis[currentNode][visV1][visV2] = true;
			if(currentNode==N) {
				if(visV1==1 && visV2==1) {
					answer = weight;
					return;
				}
			}

			for(int[] next : list[currentNode]) {
				int nextNode = next[0];
				int nextWeight = next[1];
				if(!vis[nextNode][visV1][visV2] && dist[nextNode][visV1][visV2] > nextWeight + weight) {
					if (nextNode==v1) {
						dist[nextNode][1][visV2] = nextWeight + weight;
						q.offer(new long[] {nextNode, dist[nextNode][1][visV2],1,visV2});
					} else if(nextNode==v2) {
						dist[nextNode][visV1][1] = nextWeight + weight;
						q.offer(new long[] {nextNode, dist[nextNode][visV1][1],visV1,1});
					} else {
						dist[nextNode][visV1][visV2] = nextWeight + weight;
						q.offer(new long[] {nextNode, dist[nextNode][visV1][visV2],visV1,visV2});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		vis = new boolean[N+1][2][2];
		list = new List[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}

		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[p1].add(new int[] {p2,weight});
			list[p2].add(new int[] {p1,weight});
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		bfs();
		System.out.println(answer);
	}
}
