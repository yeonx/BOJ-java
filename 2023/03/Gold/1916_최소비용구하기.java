package day0302;

import java.io.*;
import java.util.*;

public class Main_bj_1916_최소비용구하기_서울_20반_이연희 {

	static int N,M;
	static int A,B;
	static int[] weight;
	static boolean[] v;
	
	static int answer = Integer.MAX_VALUE;
	
	static List<int[]>[] bus;
	
	static void AtoB() {
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		
		q.offer(new int[] {A, 0});
		weight[A] = 0;

		while(!q.isEmpty()) {
			int[] polled = q.poll();
			
			if(polled[0] == B) {
				answer = Math.min(answer, polled[1]);
				return;
			}
			
			for(int[] go : bus[polled[0]]) {
				
				if(weight[go[0]] > polled[1] + go[1]) {
					weight[go[0]] = polled[1] + go[1];
					q.offer(new int[] {go[0], weight[go[0]]});
				}

			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        bus = new List[N+1];
        
        v = new boolean[N+1];
        weight = new int[N+1];
        
        for(int i=1;i<=N;i++) {
        	bus[i] = new ArrayList<int[]>();
        	weight[i] = Integer.MAX_VALUE;
        }
        
        for(int m=0;m<M;m++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	
        	bus[start].add(new int[] {end, weight});
        }
        
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        AtoB();
        System.out.println(answer);
	}
}
