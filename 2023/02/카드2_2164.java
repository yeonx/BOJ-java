package day0210;

import java.io.*;
import java.util.*;

public class Main_bj_2164_카드2_서울_20반_이연희 {
	
	static int N;
	static int answer;
	
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	
	static void solve() {
		answer = q.poll();
		while(!q.isEmpty()) {
			
			int next = q.poll();
			q.offer(next);
			answer = q.poll();
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        for(int i=1;i<=N;i++) {
        	q.offer(i);
        }

        solve();
        System.out.println(answer);
	}
}
