package baekjoon;

import java.io.*;
import java.util.*;

import javax.sound.sampled.Port;

public class Main_2263_트리의순회 {
	
	static int N;
	
	static int[] inOrder, postOrder;
	
	static boolean[] vis;
	
	static StringBuilder preOrder = new StringBuilder();
	
	
	static void getInOrder(int inStart, int inEnd, int postStart, int postEnd) {
		
		if(postStart >  postEnd) return;
		if(vis[postEnd]) return;

		preOrder.append(postOrder[postEnd] + " ");
		vis[postEnd] = true;
		if(postStart ==  postEnd) return;
		
		int mid = 0;
		for(int i= 0;i<=(inEnd-inStart);i++) {
			if(inOrder[i + inStart]==postOrder[postEnd]) {
				mid = i;
				break;
			}
		}
		
		getInOrder(inStart, inStart + mid-1, postStart, postStart + mid-1);
		getInOrder(inStart + mid+1, inEnd, postStart + mid, postEnd-1);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		inOrder = new int[N];
		postOrder = new int[N];
		vis = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		getInOrder(0, N-1,0,N-1);
		
		System.out.println(preOrder);
	
	}

}
