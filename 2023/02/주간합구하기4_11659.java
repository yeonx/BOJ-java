package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11659_주간합구하기4_서울_20반_이연희 {

	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[N];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
        	if(i==0) {
        		board[i] = Integer.parseInt(st.nextToken());
        		continue;
        	}
        	board[i] = Integer.parseInt(st.nextToken()) + board[i-1];
        }
        
        
        for(int i=0;i<M;i++){
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken())-1;
        	int x2 = Integer.parseInt(st.nextToken())-1;
        	if(x1>=1)
        		System.out.println(board[x2]-board[x1-1]);
        	else
        		System.out.println(board[x2]);
        	
        }

    }
}
