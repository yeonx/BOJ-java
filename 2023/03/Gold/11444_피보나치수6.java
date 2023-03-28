package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11444_피보나치수6 {
	
	static HashMap<Long, Long> F = new HashMap<>();
	
	static long fibo(long number) {
		if(number==0) return 0;
		else if(number==1 || number==2) return 1;
		else if(F.containsKey(number)) return F.get(number);
		if(number%2==0) {
			long mid = number/2;
			long m1 = fibo(mid-1);
			long m2 = fibo(mid);
			F.put(number, (2*m1+m2)*m2 % 1000000007);
			
		}else {
			long mid = (number+1)/2;
			long m1 = fibo(mid-1);
			long m2 = fibo(mid);
			F.put(number, (m1*m1 + m2*m2) % 1000000007);
		}
		
		
		return F.get(number);
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		F.put((long) 1, (long) 1);
		F.put((long) 2, (long) 1);
		
		fibo(N);
		
		System.out.println(F.get(N));

	}

}
