package day0221;

import java.io.*;
import java.util.*;

class Record{
	int win;
	int draw;
	int lose;
	
	public Record(int win, int draw, int lose) {
		this.win = win;
		this.draw = draw;
		this.lose = lose;  
	}
}

public class Main_bj_6987_월드컵_서울_20반_이연희 {
	
	static List<Record> record;
	static int[] tmp = new int[2];
	static boolean isPossible, isEnd;
	static int count;
	static int[][] matches = new int[15][2];
	
	static void backTracking(int matchCount) {
		
		if(isEnd) return;
		
		if(matchCount == 15) {
			isEnd = true;
			return;
		}
		
		int myTeam = matches[matchCount][0];
		int enemyTeam = matches[matchCount][1];
		
		if(record.get(myTeam).win > 0 && record.get(enemyTeam).lose > 0) {
			record.get(myTeam).win--;
			record.get(enemyTeam).lose--;
			backTracking(matchCount+1);
			record.get(myTeam).win++;
			record.get(enemyTeam).lose++;	
		} 
		if(record.get(myTeam).draw > 0 && record.get(enemyTeam).draw > 0) {
			record.get(myTeam).draw--;
			record.get(enemyTeam).draw--;
			backTracking(matchCount+1);
			record.get(myTeam).draw++;
			record.get(enemyTeam).draw++;	
		}
		if(record.get(myTeam).lose > 0 && record.get(enemyTeam).win > 0) {
			record.get(myTeam).lose--;
			record.get(enemyTeam).win--;
			backTracking(matchCount+1);
			record.get(myTeam).lose++;
			record.get(enemyTeam).win++;	
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int win, draw, lose;
		
		int index = 0;
		for(int i = 0; i < 6 - 1; i++) {
			for(int j = i + 1; j < 6; j++) {
				matches[index][0] = i;
				matches[index][1] = j;
				index++;
			}
		}
		
		for(int t = 0 ; t < 4 ; t++) {
			record = new ArrayList<>();

			count=0;
			int sum=0;
			isPossible = true;

			st = new StringTokenizer(br.readLine());
		
			for(int i=0;i<6;i++) {

				win = Integer.parseInt(st.nextToken());
				draw = Integer.parseInt(st.nextToken());
				lose = Integer.parseInt(st.nextToken());
				sum += (win + draw + lose);
				if(win + draw + lose != 5)
					isPossible = false;

				record.add(new Record(win, draw, lose));
			}
			
			if(sum!=30) isPossible = false;
			
			Collections.sort(record, (o1,o2) -> {
				if(o1.win ==o2.win) {
					return o1.lose - o2.lose;
				} return o2.win - o1.win;
			});
			
			if(isPossible) {
				backTracking(0);
				if(isEnd) {
					sb.append(1);
				}else {
					sb.append(0);
				}
			} else {
				sb.append(0);
			}
			sb.append(" ");
			isEnd = false;

		}
		System.out.println(sb);
	}
}

