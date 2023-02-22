package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
	
	static int[][] map;
	static int num;
	static int[] answer = new int[2];
	static StringBuilder sb = new StringBuilder();
	
	static void solve(int x, int y, int size) {
		if(size == 1) {
			answer[map[x][y]]++;
			return;
		}
		num = map[x][y];
		
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(num!=map[i][j]) {
					size = size/2;
					solve(x,y,size);
					solve(x,y+size,size);
					solve(x+size,y,size);
					solve(x+size,y+size,size);
					return;
				}
			}
		}
		answer[num]++;
		return;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        num = map[0][0];
        solve(0,0,N);

        System.out.println(answer[0] + "\n" + answer[1]);
        
        br.close();

    }
}
