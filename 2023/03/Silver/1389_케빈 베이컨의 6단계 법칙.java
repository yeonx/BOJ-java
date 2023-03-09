package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1389 {
	
	static int N,M;
	
	static List<Integer>[] list;
	static boolean[] vis;
	static int[] person;
	
	static void bfs(int num) {
		int count=0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {num,0});
		vis[num] = true;
		while(!q.isEmpty()) {
			int[] polled = q.poll();
			count+= polled[1];
			for(int tmp : list[polled[0]]) {
				if(!vis[tmp]) {
					q.offer(new int[] {tmp,polled[1]+1});
					vis[tmp] = true;
				}
			}
		}
		person[num] = count;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        list = new List[N+1];
        vis = new boolean[N+1];
        person = new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	list[a].add(b);
        	list[b].add(a);
        }
        
        for(int i=1;i<=N;i++) {
        	vis = new boolean[N+1];
        	bfs(i);
        }
        int answer = Integer.MAX_VALUE;
        int output = 0;
        for(int i=1;i<=N;i++) {
        	if(answer > person[i]) {
        		answer = person[i];
        		output = i;
        	}
        }

        System.out.println(output);
	}

}
