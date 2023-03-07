package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1676 {

	static int N;
	static int answer=0;
	
	static void solve() {

		int two=0, five=0;
		for(int i=1;i<=N;i++) {
			int tmp = i;
			if(i%2==0) {
				while(tmp%2==0 && tmp >= 2) {
					tmp = tmp / 2;
					two++;
				}
			}
			if(i%5==0) {
				while(tmp%5==0 && tmp>=5) {
					tmp = tmp / 5;
					five++;
				}
			}
		}
		
		answer = Math.min(two, five);
		
	}
	
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        solve();
        
        System.out.println(answer);

	}
	
}
