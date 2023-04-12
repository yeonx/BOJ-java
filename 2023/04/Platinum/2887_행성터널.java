package day0412;

import java.io.*;
import java.util.*;

public class Main_bj_2887_행성터널 {

	static int N, answer;
	static int[] parent;
	static Point[] points;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	
	static int getParent(int x) {
		if(parent[x]==x) return x;
		return parent[x] = getParent(parent[x]);
	}
	
	static void unionParent(int a, int b) {
		 a = getParent(a);
		 b = getParent(b);
		 
		 if(a<b) parent[b] = a;
		 else parent[a] = b;
	}
	
	static class Point {
		int num;
		int x;
		int y;
		int z;
		
		public Point(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Edge{
		int start;
		int end;
		int weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		points = new Point[N];
		parent = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			points[i] = new Point(i, x, y, z);
		}
		
		Arrays.sort(points, (p1,p2) -> p1.x - p2.x);
		for(int i=0;i<N-1;i++) {
			int weight = Math.abs(points[i].x - points[i+1].x);
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		Arrays.sort(points, (p1,p2) -> p1.y- p2.y);
		for(int i=0;i<N-1;i++) {
			int weight = Math.abs(points[i].y - points[i+1].y);
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		Arrays.sort(points, (p1,p2) -> p1.z - p2.z);
		for(int i=0;i<N-1;i++) {
			int weight = Math.abs(points[i].z - points[i+1].z);
			edgeList.add(new Edge(points[i].num, points[i+1].num, weight));
		}
		
		for(int i=0 ;i<N;i++) parent[i] = i;
		
		Collections.sort(edgeList, (e1,e2) -> e1.weight - e2.weight );
		
		for(int i=0;i<edgeList.size();i++) {
			Edge edge = edgeList.get(i);
			
			if(getParent(edge.start) != getParent(edge.end)) {
				answer += edge.weight;
				unionParent(edge.start, edge.end);
			}
		}
		
		System.out.println(answer);
	}
}
