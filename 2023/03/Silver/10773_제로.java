package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10773_제로 {
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        int N = Integer.parseInt(br.readLine());
        
        
        for(int i=0;i<N;i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	if(num==0) {
        		q.pollLast();
        	}else {
        		q.offerLast(num);
        	}
        }
        int answer=0;
        
        while(!q.isEmpty()) {
        	answer += q.poll();
        }
        System.out.println(answer);
	}

}
