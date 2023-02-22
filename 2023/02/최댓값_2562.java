package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2562 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int max = Integer.MIN_VALUE;
		int index = -1;
		
		for(int i=0;i<9;i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp > max) {
				max = tmp;
				index = i+1;
			}
		}
		sb.append(max).append("\n").append(index);
		System.out.println(sb);
		
	}
	
}
