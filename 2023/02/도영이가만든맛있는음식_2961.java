package day0209;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가만든맛있는음식_서울_20반_이연희 {
	static int N;
	static int[] s,b;
	static int tmp_s=1, tmp_b=0;
	static int answer=Integer.MAX_VALUE;
	static int count;
	
	static void comb(int cnt, int start, int tmp_s,int tmp_b) {
		if(cnt == count) {
			answer = Math.min(answer, Math.abs(tmp_b-tmp_s));
			return;
		}
		for(int i=start;i<N;i++) {
			tmp_s = s[i]*tmp_s;
			tmp_b = b[i]+tmp_b;
			comb(cnt+1, i + 1, tmp_s,tmp_b ); // 조합
			tmp_s = tmp_s/s[i];
			tmp_b = tmp_b - b[i];
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        s = new int[N];
        b = new int[N];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	s[i] = Integer.parseInt(st.nextToken());
        	b[i] = Integer.parseInt(st.nextToken());
        }
        for(count=1;count<=N;count++) {
        	comb(0,0,1,0);
        }
        System.out.println(answer);
	}
}
