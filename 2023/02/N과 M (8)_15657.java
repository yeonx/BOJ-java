package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15657 {
	
	static int N, M;
	
	static int[] a, b;
	static boolean[] v;
	
	static ArrayList<int[]> list = new ArrayList<>();
	
	static void perm(int cnt, int start) {
		if(cnt == M) {
			int[] tmp = new int[M];

			for(int i=0;i<M;i++) {
				tmp[i] = b[i];
			}
			list.add(tmp);
			return;
		}
		for(int i=start;i<N;i++) {
//			if(v[i]) continue;
//			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1,i);
//			v[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		a = new int[N];
		v = new boolean[N];
		
		b = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		perm(0,0);
		
		Collections.sort(list, (o1,o2) -> {
			int i;
			for(i=0;i<M;i++) {
				if(o1[i]==o2[i]) {
					continue;
				} else {
					break;
				}
			}
			return o1[i] - o2[i];
		});

		
		for(int[] tmp : list) {
			for(int i =  0;i<tmp.length;i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
