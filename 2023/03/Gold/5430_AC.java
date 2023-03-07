package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_5430 {
	
	static int p;
	static ArrayDeque<Integer> q;
	
	static int flag=0;
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0;t<T;t++) {
        	boolean isEnd = false;
        	String command = br.readLine();
        	p = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine(),"[,]");

        	q = new ArrayDeque<>();
        	flag=0;

        	for(int i=0;i<p;i++) {
        		q.offer(Integer.parseInt(st.nextToken()));
        	}

        	for(int i=0;i<command.length();i++) {
        		if(command.charAt(i)=='R') {
        			flag = (flag+1)%2;
        		} else {
        			if(q.isEmpty()) {
        				sb.append("error\n");
        				isEnd = true;
        				break;
        			}
        			
        			if(flag==0) {
        				q.pollFirst();
        			} else {
        				q.pollLast();
        			}
        		}
        	}
        	
        	if(!isEnd) {
	        	sb.append("[");
	        	while(!q.isEmpty()) {
	        		if(flag==0) {
	        			sb.append(q.pollFirst());
        			} else {
        				sb.append(q.pollLast());
        			}
	        		if(!q.isEmpty())
	        			sb.append(",");
	        	}
	        	sb.append("]\n");
        	}
        }
        System.out.print(sb);
	}

}
