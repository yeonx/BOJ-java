package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1992_쿼드트리_서울_20반_이연희 {
	
	static int N, num;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	                                                                        
	static void solve(int x, int y, int size) {
		if(size == 1) {
			sb.append(arr[x][y]);
			return;
		}
		num = arr[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(num!=arr[i][j]) {
					sb.append("(");
					size = size/2;
					solve(x,y,size);
					solve(x,y+size,size);
					solve(x+size,y,size);
					solve(x+size,y+size,size);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(arr[x][y]);
		return;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	String tmp = st.nextToken();
        	for(int j=0;j<N;j++) {
        		arr[i][j] = tmp.charAt(j) - '0';
        	}
        }
        
        solve(0,0,N);
        System.out.println(sb);

	}
}
