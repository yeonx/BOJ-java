package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2473 {

	static int N;
	static Long[] arr;
	static StringBuilder sb = new StringBuilder();
	
	static Long answer = 3000000000L;
	
	static void solved(int left, int right) {
		if(answer==0) return;
		
		int start = left-1;
		
		while(left<right) {
			Long total = arr[left] + arr[right] + arr[start];
			if(answer > Math.abs(total)) {
				sb = new StringBuilder();
				sb.append(arr[start] + " " + arr[left] + " " + arr[right]);
				answer = Math.abs(total);
			}
			if(total > 0) right--;
			else left++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new Long[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int start=0;start<N-2;start++) {
			solved(start+1,N-1);
		}
		
		System.out.println(sb);
	}
}
