package baekjoon;

import java.io.*;
import java.util.*;

public class Main_18870 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N], sortArr = new int[N], rank = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortArr[i] = arr[i];
		}
		
		Arrays.sort(sortArr);
		
		int count=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(sortArr[i])) {
				map.put(sortArr[i], count);
				count++;
			}
		}
		
		for(int i=0;i<N;i++) {
			rank[i] = map.get(arr[i]);
		}
		

		for(int i=0;i<N;i++) {
			sb.append(rank[i] + " ");
		}
		System.out.println(sb);

	}

}
