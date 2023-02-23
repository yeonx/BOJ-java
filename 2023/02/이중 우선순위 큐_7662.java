package baekjoon;

import java.io.*;
import java.util.*;

public class Main_7662 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T;t++) {

        	int K = Integer.parseInt(br.readLine());
        	TreeMap<Integer, Integer> map = new TreeMap<>();
        	
        	for(int k=0;k<K;k++) {
        		st = new StringTokenizer(br.readLine());

        		String command = st.nextToken();
        		int number = Integer.parseInt(st.nextToken());
        		
        		if(command.equals("I")) {
        			map.put(number, map.getOrDefault(number,0)+1);
        		
        		}else if(!map.isEmpty()) {
        			if(number == -1) {
        				int minKey = map.firstKey();
        				if(map.get(minKey)==1) {
        					map.remove(minKey);
        				}else{
        					map.put(minKey, map.get(minKey)-1);
        				}
        			}else {
        				int maxKey = map.lastKey();
        				if(map.get(maxKey)==1) {
        					map.remove(maxKey);
        				}else{
        					map.put(maxKey, map.get(maxKey)-1);
        				}
        			}

        		}
        	}   	
        	if(map.isEmpty()) {
        		sb.append("EMPTY\n");
        	} else {
        		sb.append(map.lastKey() + " " + map.firstKey()+"\n");
        	}
        }
        System.out.println(sb.toString());
	}
}
