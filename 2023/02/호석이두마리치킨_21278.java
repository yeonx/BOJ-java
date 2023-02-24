package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_21278 {
	
	static int N, M;
	static int[] pick = new int[2];
	static int answer = Integer.MAX_VALUE;
	static int[] chicken = new int[2];
	static List<Integer>[] graph;
	
	static boolean[] vis;
	static int[] disHome;
	
	static void bfs() {
	
		int dis=0;
		disHome = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			disHome[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<2;i++) {
			Queue<int[]> q = new ArrayDeque<>();
			vis  = new boolean[N+1];
			
			q.offer(new int[] {pick[i],0});
			vis[pick[i]] = true;

			
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				if(disHome[tmp[0]] > tmp[1]) {
					disHome[tmp[0]] = tmp[1];
				}
				
				for(int j: graph[tmp[0]]) {
					if(!vis[j]) {
						vis[j] = true;
						q.offer(new int[] {j, tmp[1]+1});
					}
				
				}
				
				
			}
		}

		for(int i=1;i<=N;i++) {
			dis+=disHome[i];
		}

		if(answer > dis) {
			answer = dis;
			for(int i=0;i<2;i++) {
				chicken[i] = pick[i];
			}
		}
		
	}
	
	static void comb(int cnt, int start) {
		if(cnt==2) {
			bfs();
			return;
		}
		for(int i=start;i<=N;i++) {
			pick[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new List[N+1];
        vis = new boolean[N+1];
        for(int i=1;i<=N;i++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int n1 = Integer.parseInt(st.nextToken());
        	int n2 = Integer.parseInt(st.nextToken());
        	
        	graph[n1].add(n2);
        	graph[n2].add(n1);
        }
        comb(0,1);
        
        System.out.println(chicken[0] + " " + chicken[1] + " " + answer*2);
	}

}
