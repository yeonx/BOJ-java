package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {
	
	static int answer = -1;
	
	static void solve(int A, int B, int count) {
		if(A==B) {
			answer = count;
			return;
		} else if(A>B) {
			answer=-1;
			return;
		}
		if(B%2==0) {
			solve(A,B/2,count+1);
		} else if(B%10==1){
			solve(A,B/10,count+1);
		} else {
			answer=-1;
			return;
		}
	}
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        solve(A,B,1);
        System.out.println(answer);
        
        
        
	}

}
