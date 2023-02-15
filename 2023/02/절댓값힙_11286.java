package day0215;

import java.io.*;
import java.util.*;

public class Main_bj_11286_절대값힙_서울_20반_이연희 {
	
	static int N;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((l1,l2) -> {
        	if(Math.abs(l1) == Math.abs(l2)) return l1-l2;
        	return Math.abs(l1) - Math.abs(l2);
        }
        );
        
        for(int i=0;i<N;i++) {
        	int tmp = Integer.parseInt(br.readLine());
        	if(tmp!=0)
        		pq.offer(tmp);
        	else {
        		if(pq.isEmpty())
        			sb.append("0").append("\n");
        		else
        			sb.append(pq.poll()).append("\n");
        	}
        }
        
        System.out.println(sb);
	}
}
