package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9375 {
	
	static int answer;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int t=0;t<T;t++) {
        	int N = Integer.parseInt(br.readLine());
        	HashMap<String, Integer> map = new HashMap<>();
        	
        	for(int i=0;i<N;i++) {
        		st = new StringTokenizer(br.readLine());
        		String s1 = st.nextToken();
        		String s2 = st.nextToken();
        		
        		if(map.containsKey(s2)) {
        			map.put(s2, map.get(s2)+1);
        		}else {
        			map.put(s2,1);
        		}
        	}

        	answer=1;

        	for(int n : map.values()) {
        		answer = answer*(n+1);
        	}
        	
        	sb.append(answer-1 + "\n");
        }
        
        System.out.println(sb.toString());
        
	}

}
