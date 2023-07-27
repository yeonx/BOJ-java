package baekjoon;

import java.io.*;
import java.util.*;

public class Main_27172 {
	static int N;
	static int SIZE = 1000001;
	static boolean[] cards = new boolean[SIZE];
	static int[] score = new int[SIZE];
	static int[] player;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		player = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			player[i] = Integer.parseInt(st.nextToken());
			cards[player[i]] = true;
		}
		
		for(int p : player) {
			for(int s = p*2; s<SIZE ;s+=p) {
				if(cards[s]) {
					score[p]++;
					score[s]--;
				}
			}
		}
		
		
		for(int p : player) {
			sb.append(score[p] + " ");
		}
		System.out.println(sb);

	}
}
