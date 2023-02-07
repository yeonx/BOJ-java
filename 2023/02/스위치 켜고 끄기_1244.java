import java.io.*;
import java.util.*;

public class Main {
	
	static int[] switchs;
	static int switchNum;
	
	static void onOff(int index) {
		switchs[index] = (switchs[index]==0) ? 1 : 0;
	}
	
	static void switchOperation(int mw, int operationNum) {
		if(mw==1) {
			for(int i=1 ; operationNum*i <= switchNum ; i++) {
				onOff(i*operationNum);
			}
		} else {
			onOff(operationNum);
			for(int i=1; operationNum-i>0 && operationNum + i <= switchNum; i++) {
				if(switchs[operationNum - i] == switchs[operationNum + i]) {
					onOff(operationNum - i);
					onOff(operationNum + i);
				}
				else {
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
  
		switchNum = Integer.parseInt(st.nextToken());
		switchs = new int[switchNum+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1 ; i <= switchNum ; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int peopleNum = Integer.parseInt(st.nextToken());
		int mw, operationNum;
		
		for(int i=0 ; i< peopleNum ; i++) {
			st = new StringTokenizer(br.readLine());
			mw = Integer.parseInt(st.nextToken());
			operationNum = Integer.parseInt(st.nextToken());
			switchOperation(mw, operationNum);
		}
		
		for(int i=1;i<=switchNum;i++) {
			sb.append(switchs[i]).append(" ");
			if(i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
}
