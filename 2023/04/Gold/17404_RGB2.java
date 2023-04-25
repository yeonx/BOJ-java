import java.io.*;
import java.util.*;

public class Main_17404_RGB2 {
	static int N;
	static int[][] house,copyHouse;
	static int answer = Integer.MAX_VALUE;
	
	static void copy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				copyHouse[i][j] = house[i][j];
			}
		}
	}
	
	static void red() {
		copy();

		copyHouse[1][0] = Integer.MAX_VALUE;
		copyHouse[1][1] += copyHouse[0][0];
		copyHouse[1][2] += copyHouse[0][0];
		
		for(int i=2;i<N;i++) {
			for(int j=0;j<3;j++) {
				copyHouse[i][j] = copyHouse[i][j] + Math.min(copyHouse[i-1][(j+1)%3], copyHouse[i-1][(j+2)%3]);
			}
		}
		
		answer = Math.min(answer, Math.min(copyHouse[N-1][1], copyHouse[N-1][2]));
	}
	
	static void green() {
		copy();

		copyHouse[1][1] = Integer.MAX_VALUE;
		copyHouse[1][0] += copyHouse[0][1];
		copyHouse[1][2] += copyHouse[0][1];
		
		for(int i=2;i<N;i++) {
			for(int j=0;j<3;j++) {
				copyHouse[i][j] = copyHouse[i][j] + Math.min(copyHouse[i-1][(j+1)%3], copyHouse[i-1][(j+2)%3]);
			}
		}
		
		answer = Math.min(answer, Math.min(copyHouse[N-1][0], copyHouse[N-1][2]));
	}
	
	static void blue() {
		copy();

		copyHouse[1][2] = Integer.MAX_VALUE;
		copyHouse[1][1] += copyHouse[0][2];
		copyHouse[1][0] += copyHouse[0][2];
		
		for(int i=2;i<N;i++) {
			for(int j=0;j<3;j++) {
				copyHouse[i][j] = copyHouse[i][j] + Math.min(copyHouse[i-1][(j+1)%3], copyHouse[i-1][(j+2)%3]);
			}
		}
		
		answer = Math.min(answer, Math.min(copyHouse[N-1][1], copyHouse[N-1][0]));
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		copyHouse = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		red();
		green();
		blue();
		System.out.println(answer);
	}
}
