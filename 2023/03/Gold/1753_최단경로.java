package day0302;

import java.io.*;
import java.util.*;

public class Main_bj_1753_최단경로_서울_20반_이연희 {

	static int N,M;
	static int A;
	static int[] weight;
	static boolean[] v;
	static List<int[]>[] bus;
	
	static void AtoB() {
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		v = new boolean[N+1];
		q.offer(new int[] {A, 0});
		weight[A] = 0;

		while(!q.isEmpty()) {
			int[] polled = q.poll();
			if(v[polled[0]]) continue;
			v[polled[0]] = true;
			for(int[] go : bus[polled[0]]) {
				if(!v[go[0]] && weight[go[0]] > polled[1] + go[1]) {
					weight[go[0]] = polled[1] + go[1];
					q.offer(new int[] {go[0], weight[go[0]]});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = Integer.parseInt(br.readLine());
        
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
        
        AtoB();
        
        for(int i=1;i<=N;i++) {
        	if(!v[i]) sb.append("INF\n");
        	else sb.append(weight[i]+"\n");
        }
        System.out.println(sb);  
	}
}
