import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[] cable;
	static int maxLenCable = Integer.MIN_VALUE;
	static long answer = 0;

	static void cut(long start, long end) {
//		System.out.println(start + " " + end);
		if(start>end) return;
		if(end==1) {
			answer =1;
			return;
		}
		long mid = (start + end) / 2 ;
		
		int total = 0;
		
		for(int i=0;i<N;i++) {
			total += cable[i]/mid;
		}
		
		if(total>=M) {
			if(answer < mid)
				answer = mid;
			cut(mid+1, end);
		} else  {
			cut(start, mid-1);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cable = new int[N];
		
		for(int i=0;i<N;i++) {
			cable[i] = Integer.parseInt(br.readLine());
			if(cable[i] >  maxLenCable)	maxLenCable = cable[i];
		}
		
		cut(0,maxLenCable);
		System.out.println(answer);

	}

}
