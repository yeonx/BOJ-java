import java.io.*;
import java.util.*;

public class Main_bj_14891_톱니바퀴 {
	
	static int right = 0;
	static int left = 1;
	
	static int[] direction = new int[4];
	
	static int[][]t = new int[4][2];
	static int[][] saw = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<4;i++) {
			String tmp = br.readLine();
			for(int j=0;j<8;j++) {
				saw[i][j] = tmp.charAt(j) - '0';
			}
		}
		for(int i=0;i<4;i++) {
			t[i][right] = 2;
			t[i][left] = 6;
		}
		
		int test = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;i<test;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int ro = Integer.parseInt(st.nextToken());
			direction = new int[4];
			direction[num-1] = ro;
			checkDirection(num-1, ro);
			rotation();
		}

		for(int j=0, mul=1;j<4;j++,mul*=2) {
			int tmp = t[j][left]+2;
			tmp = tmp%8;
			answer += (saw[j][tmp])*mul;
		}
		System.out.println(answer);
	}
	
	static void rotation() {
		for(int i=0;i<4;i++) {
			if(direction[i]==0) continue;
			else if(direction[i]==1) {
				t[i][right] = t[i][right]-1==-1?7:t[i][right]-1;
				t[i][left] =  (t[i][right]+4)%8;
			} else {
				t[i][right] = t[i][right]+1==8?0:t[i][right]+1;
				t[i][left] = (t[i][right]+4)%8;
			}
		}
	}

	static void checkDirection(int num, int d) {
		if(0<=num&&num<4) {
			if(num+1<4 && saw[num][t[num][right]]!=saw[num+1][t[num+1][left]] && direction[num+1]==0) {
				direction[num+1] = d*(-1);
				checkDirection(num+1, d*(-1));
			}
			if(num-1 >= 0 && saw[num][t[num][left]]!=saw[num-1][t[num-1][right]] && direction[num-1]==0) {
				direction[num-1] = d*(-1);
				checkDirection(num-1, d*(-1));
			}
		} 
	}
}
