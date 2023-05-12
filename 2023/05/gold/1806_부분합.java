import java.io.*;
import java.util.*;

public class Main_1806_부분합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0, right = 0;
		int sum = arr[0], minLen = Integer.MAX_VALUE;
		
		while(right < N && left < N) {
			if(sum >= S) {
				if(minLen > right-left+1) {
					minLen = right-left+1;
				}
				
				sum -= arr[left];
				left++;
			} else if (sum<S && right < N-1){
				right++;
				sum += arr[right];
			} else break;
		}
		if(minLen==Integer.MAX_VALUE) minLen=0;
		System.out.println(minLen);
	}

}
