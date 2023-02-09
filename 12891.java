package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_12891_DNA비밀번호_서울_20반_이연희 {
	
	static int S,P,answer=0;
	static String dna;
	static int[] count = new int[4];
	static int[] dnaCount = new int[4];
	
	static void init() {
		for(int i=0;i<P;i++) {
        	if(dna.charAt(i)=='A')
        		dnaCount[0]++;
        	else if(dna.charAt(i)=='C')
        		dnaCount[1]++;
        	else if(dna.charAt(i)=='G')
        		dnaCount[2]++;
        	else if(dna.charAt(i)=='T')
        		dnaCount[3]++;
        }
		for(int i=0;i<4;i++) {
        	if(count[i]>dnaCount[i]) {
        		return;
        	}
        }
		answer++;
	}

	static void check(int stand) {
		for(int i=0;i<P;i++) {
        	if(dna.charAt(stand + i)=='A')
        		dnaCount[0]++;
        	else if(dna.charAt(stand + i)=='C')
        		dnaCount[1]++;
        	else if(dna.charAt(stand + i)=='G')
        		dnaCount[2]++;
        	else if(dna.charAt(stand + i)=='T')
        		dnaCount[3]++;
        }
		for(int i=0;i<4;i++) {
        	if(count[i]>dnaCount[i]) {
        		return;
        	}
        }
		answer++;
	}

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
        	count[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<=S-P;i++) {
        	check(i);
        }
        System.out.println(answer);
	}
}
