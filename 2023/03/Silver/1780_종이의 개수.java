package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	static int N;
	static int[][] map;
    
	static int[] answer = new int[3];
	
	static void check(int startY, int startX, int endY, int endX, int num) {
		if(startY==endY || startX==endX) {
			answer[num]++;
			return;
		}
		for(int y = startY;y<endY;y++) {
			for(int x=startX;x<endX;x++) {
				if(map[y][x]!=num) {
					check(startY, 						startX, 					startY + (endY-startY)/3, 	startX + (endX-startX)/3, 	map[startY][startX]);
					check(startY, 						startX + (endX-startX)/3, 	startY + (endY-startY)/3,   startX + (endX-startX)/3*2, map[startY][startX + (endX-startX)/3]);
					check(startY, 						startX + (endX-startX)/3*2, startY + (endY-startY)/3, 	endX, 						map[startY][startX + (endX-startX)/3*2]);
					
					check(startY + (endY-startY)/3, 	startX, 					startY + (endY-startY)/3*2, startX + (endX-startX)/3, 	map[startY + (endY-startY)/3][startX]);
					check(startY + (endY-startY)/3, 	startX + (endX-startX)/3, 	startY + (endY-startY)/3*2, startX + (endX-startX)/3*2, map[startY + (endY-startY)/3][startX + (endX-startX)/3]);
					check(startY + (endY-startY)/3, 	startX + (endX-startX)/3*2, startY + (endY-startY)/3*2, endX, 						map[startY + (endY-startY)/3][startX + (endX-startX)/3*2]);
					
					check(startY + (endY-startY)/3*2, 	startX, 					endY, 						startX + (endX-startX)/3, 	map[startY + (endY-startY)/3*2][startX]);
					check(startY + (endY-startY)/3*2, 	startX + (endX-startX)/3, 	endY, 						startX + (endX-startX)/3*2, map[startY + (endY-startY)/3*2][startX + (endX-startX)/3]);
					check(startY + (endY-startY)/3*2, 	startX + (endX-startX)/3*2, endY, 						endX,						map[startY + (endY-startY)/3*2][startX + (endX-startX)/3*2]);
					return;
				}
			}
		}

		answer[num+1]++;

	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        check(0,0,N,N,map[0][0]);
        
        for(int i=0;i<3;i++) {
        	System.out.println(answer[i]);
        }
	}
}
