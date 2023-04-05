import java.io.*;
import java.util.*;

public class Main_bj_2458_키순서 {
	
	static int N,M;
	static List<Integer>[] list, reverseList;
	static int answer;
	
	static boolean[] vis;
	

	static void bfs(int stand) {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		vis = new boolean[N+1];
		q.offer(stand);
		vis[stand] = true;
		int conn = 1;
		
		while(!q.isEmpty()) {
			int person = q.poll();
			for(int next : list[person]) {
				if(!vis[next]) {
					q.offer(next);
					vis[next] = true;
					conn++;
				}
			}
		}
		q.offer(stand);
		while(!q.isEmpty()) {
			int person = q.poll();
			for(int next : reverseList[person]) {
				if(!vis[next]) {
					q.offer(next);
					vis[next] = true;
					conn++;
				}
			}
		}
		if(conn==N) answer++;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1;test_case<=T;test_case++) {
			sb.append("#" + test_case + " ");

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			list = new List[N+1];
			reverseList = new List[N+1];
			
			for(int i=1;i<=N;i++) {
				list[i] = new ArrayList<>();
				reverseList[i] = new ArrayList<>();
			}
			
			answer = 0;
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				reverseList[b].add(a);
			}
			
			for(int i=1;i<=N;i++) {
				bfs(i);
			}

			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
}
