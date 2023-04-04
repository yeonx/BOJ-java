package day0404;

import java.io.*;
import java.util.*;

public class Main_bj_1786_찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int TLen = T.length, PLen = P.length;
		
		int[] pi = new int[PLen];
		for(int i=1,j=0;i<PLen;i++) {
			while(j>0 && P[i]!=P[j]) j = pi[j-1];
			if(P[i]==P[j]) pi[i] = ++j;
			else pi[i] = 0;
		}
		
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0,j=0;i<TLen;i++) {
			while(j>0 && T[i]!=P[j]) j = pi[j-1];
			if(T[i]==P[j]) {
				if(j == PLen-1) { // j가 패턴의 마지막 인덱스라면 
					cnt++; // 카운트 증가
					list.add(i-j+1);  
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		sb.append(cnt + "\n");
		for(int tmp: list) {
			sb.append(tmp + " ");
		}
		System.out.println(sb);
		
	}

}
