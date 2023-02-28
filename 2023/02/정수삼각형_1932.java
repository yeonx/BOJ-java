package day0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1932_정수삼각형_서울_20반_이연희 {
	
	static int N;
	static int[] preArr, nextArr;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        int answer = Integer.MIN_VALUE;
        
        preArr = new int[1];
        preArr[0] = Integer.parseInt(br.readLine());
        for(int i=2;i<=N;i++) {
        	nextArr = new int[i];
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<i;j++) {
        		if(j==0) nextArr[j] = Integer.parseInt(st.nextToken()) + preArr[j];
        		else if(j==i-1) nextArr[j] = Integer.parseInt(st.nextToken()) + preArr[j-1];
        		else nextArr[j] = Integer.parseInt(st.nextToken()) + Math.max(preArr[j-1], preArr[j]);
            }
        	preArr = new int[i];
        	for(int j=0;j<i;j++) preArr[j] = nextArr[j];
        }
        
        for(int i=0;i<N;i++) {
        	answer = Math.max(answer, preArr[i]);
        }
        
        System.out.println(answer);
        
	}

}
