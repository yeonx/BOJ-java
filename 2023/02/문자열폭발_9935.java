package day0228;

import java.io.*;
import java.util.*;

public class Main_bj_9935_문자열폭발_서울_20반_이연희 {
	
	static String str;
	static String del;
	
	static void stack() {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			stack.push(str.charAt(i));
			if (stack.size()>=del.length() && str.charAt(i) == del.charAt(del.length()-1)) {
				int flag=0;
				for(int j=0;j<del.length();j++) {
					if(stack.get(stack.size()-1-j)!=del.charAt(del.length()-1-j)) {
						flag=1;
					}
				}
				if(flag==0) {
					for(int j=0;j<del.length();j++) {
						stack.pop();
					}
				}
			}
		}
		
//		for (char ch : stack)
//            sb.append(ch);
//
//        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");

		if(stack.size()==0) sb.append("FRULA");
		else {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
		}
		
		 System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        del = br.readLine();
        
        stack();
	}
}
