package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.management.Query;
import javax.security.auth.callback.ChoiceCallback;

class Spot{
	int x;
	int y;
	
	public Spot(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main_bj_15686_치킨배달_서울_20반_이연희 {
	
	static int N,M;
	static int minDistance = Integer.MAX_VALUE;
	static int[][] arr;
	static List<Spot> ckicken = new ArrayList<>(), home = new ArrayList<>();
	static List<Spot> pickCkicken = new ArrayList<>();

	
	
	static void findStore() {
		
		int chickenDistance=0;
		
		for(Spot spot : home) {
			int tmp = Integer.MAX_VALUE;
		
			
			for(Spot pc : pickCkicken) {
				if(tmp > Math.abs(spot.x-pc.x) + Math.abs(spot.y-pc.y)) {
					tmp = Math.abs(spot.x-pc.x) + Math.abs(spot.y-pc.y);
				}
			}
			chickenDistance+=tmp;
		}
		
		if(chickenDistance < minDistance) {
			minDistance = chickenDistance;
		}
	}
	
	static void comb(int start) {
		if(pickCkicken.size()==M) {
			findStore();
			return;
		}
		for(int i=start;i<ckicken.size();i++) {
			pickCkicken.add(ckicken.get(i));
			comb(i+1);
			pickCkicken.remove(ckicken.get(i));
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					ckicken.add(new Spot(i,j));
				} else if(arr[i][j] == 1) {
					home.add(new Spot(i,j));
				}
			}
		}
		comb(0);
		System.out.println(minDistance);
		
	}
}
