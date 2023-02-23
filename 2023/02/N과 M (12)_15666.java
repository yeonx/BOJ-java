package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15666 {

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
			int stand=M-1;
			for(i=0;i<M;i++) {
				if(o1[i]==o2[i]) {
					continue;
				} else {
					stand = i;
					break;
				}
			}
			return o1[stand] - o2[stand];
		});

		
		int[] pre = new int[M];
		int index=0;
		for(int[] tmp : list) {
			int flg=0;
			if(index!=0) {
				for(int i =  0;i<tmp.length;i++) {
					if(pre[i]!=tmp[i]) {
						flg=1;
					}
				}
				
			}
			if(flg==1 || index==0) {
				for(int i =  0;i<tmp.length;i++) {
					sb.append(tmp[i]).append(" ");
					pre[i] = tmp[i];
				}
				sb.append("\n");
			}
			index++;
		}
		
		System.out.println(sb);
		
	}
	
}
