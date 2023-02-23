package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407 {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

	
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        BigInteger num1 = new BigInteger("1");
        BigInteger num2 = new BigInteger("1");

        for(int i=0;i<m;i++) {
        	num1 = num1.multiply(new BigInteger(String.valueOf(n-i)));
        	num2 = num2.multiply(new BigInteger(String.valueOf(m-i)));
        }
        
        System.out.println(num1.divide(num2));
	}

}
