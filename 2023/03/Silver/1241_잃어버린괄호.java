package day0307;

import java.io.*;
import java.util.*;

public class Main_bj_1241_잃어버린괄호_서울_20반_이연희 {

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int add=0, min=0;
        int flg=1;
        int number=0;
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)=='-'||str.charAt(i)=='+') {
        		if(flg==1) add += number;
        		else min +=number;
        		if(str.charAt(i)=='-') flg=-1;
        		number = 0;
        	} else {
        		number = number * 10 + str.charAt(i) - '0';
        	}
        }
        if(flg==1) add += number;
		else min +=number;
        System.out.println(add-min);
        
	}
}
