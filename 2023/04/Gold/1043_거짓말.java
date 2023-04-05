package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_1043_거짓말 {
	
	static int N,M;
	
	static List<Integer>[] person;
	static List<Integer>[] party;
	static int know;
	static boolean[] knowPerson;
	
	
	static void bfs(int know) {
		knowPerson = new boolean[N+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(know);
		knowPerson[know] = true;
		
		while(!q.isEmpty()) {
			int polled = q.poll();
			for(int tmp : person[polled]) {
				if(!knowPerson[tmp]) {
					q.offer(tmp);
					knowPerson[tmp] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		person = new List[N+1];
		party = new List[M];
		for(int i=1;i<=N;i++) {
			person[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			party[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int knowTruthNum = Integer.parseInt(st.nextToken());
		boolean isEnd = false;
		if(knowTruthNum==0) {
			isEnd = true;
		}
		ArrayList<Integer> list = new ArrayList<>();
		
		if(!isEnd) {
			for(int i=0;i<knowTruthNum;i++) {
				int know = Integer.parseInt(st.nextToken());
				list.add(know);
			}
			know = list.get(0);
			for(int per : list) {
				for(int per2 : list) {
					if(per==per2) continue;
					person[per].add(per2);
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());

			for(int j=0;j<p;j++) {
				int pNum = Integer.parseInt(st.nextToken());
				party[i].add(pNum);
			}

			for(int per : party[i]) {
				for(int per2 : party[i]) {
					if(per==per2) continue;
					person[per].add(per2);
				}
			}
			
		}
		int answer=M;

		if (!isEnd) {

			bfs(know);
			answer=0;
			for(int i=0;i<M;i++) {
				boolean canGo = true;
				for(int per : party[i]) {
					if(knowPerson[per]) {
						canGo = false;
					}
				}
				if(canGo) answer++;
			}
		
		}
		System.out.println(answer);
	}

}
