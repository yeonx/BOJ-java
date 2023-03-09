package baekjoon;

import java.io.*;
import java.util.*;

public class Main_5525 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        String str = br.readLine();
        
        int answer = 0;
        int count=0;

        for(int i=1;i<M-1;i++) {
        	
        	if(str.charAt(i-1)=='I'&&str.charAt(i)=='O' && str.charAt(i+1)=='I') {
        		count++;
        		if(count==N) {
        			answer++;
        			count--;
        		}
        		i++;
        	}else {
        		count=0;
        	}
//        	if(flag==1 && str.charAt(i)=='I') {
//        		flag=0;
//        		count++;
//        	} else if(flag==0 && str.charAt(i)=='O') {
//        		flag=1;
//        		count++;
//        	}else if(i!=0 && str.charAt(i-1)=='I' && str.charAt(i)=='I') {
//        		flag=0;
//        		count=1;
//        	} else {
//        		count=0;
//        		flag=1;
//        	}
//        	
//        	if(count==done) {
////        		System.out.println(i);
//        		answer++;
//        		count=count-2;
//        		if(i+1 < M && str.charAt(i+1)=='I') {
//        			flag=1;
//        			count=0;
//        		} 
//        	}
        }
        System.out.println(answer);
	}

}
