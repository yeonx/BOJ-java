package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1918_후위표기식 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		String str = br.readLine();
		
		boolean isOpen = true;
		
		for(int i=0;i<str.length();i++) {
			char tmp = str.charAt(i);
			if(tmp=='+' || tmp=='-') {
				while(!stack.isEmpty()) {
					char check = stack.pollLast();
					if(check=='(') {
						stack.offer(check);
						break;
					}
					sb.append(check);
				}
				stack.offer(tmp);
				
			}else if(tmp=='*' || tmp=='/') {
				if(!stack.isEmpty() && (stack.peekLast()=='*'||stack.peekLast()=='/')) {
					sb.append(stack.pollLast());
				}
				stack.offer(tmp);
			}else if(tmp=='(' || tmp==')') {
				if(tmp=='(') {
					stack.offer(tmp);
				}
				else {
					while(!stack.isEmpty()) {
						char check = stack.pollLast();
						if(check=='(') 
							break;
						sb.append(check);
					}
				}
			}else {
				sb.append(tmp);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		System.out.println(sb);
	}


}
