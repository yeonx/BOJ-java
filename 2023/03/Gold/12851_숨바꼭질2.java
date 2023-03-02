package day0302;
import java.io.*;
import java.util.*;

public class Main_bj_12851_숨바꼭질2_서울_20반_이연희 {
	
	static int N,K;
	static int answer=Integer.MAX_VALUE;
	static int num=0;
	static boolean visited[] = new boolean[100001];
	
	static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {N,0});
		visited[N] = true;

		while(!q.isEmpty()) {

			int[] point = q.poll();
			int count = point[1];
			visited[point[0]] = true;
			
			if(count > answer) return;
			
			if(point[0] == K) {
				if(answer > count) {
					num++;
					answer = count;
				}else if(answer == count) {
					num++;
				}
			}
			
			int[] a = new int[3];
			
			a[0] = point[0]-1;
			a[1] = point[0]+1;
			a[2] = 2*point[0];
			
			for(int i=0;i<3;i++) {
				if(0<=a[i] && a[i]<=100000 && !visited[a[i]]) {
					
					q.offer(new int[] {a[i],count+1});			
				}
			}

		}
		
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
	
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs();
        
        System.out.println(answer + "\n" + num);
	}

}
