package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1759_암호만들기_서울_20반_이연희 {
	
	static int L, C;
	static char[] dic;
	static char[] pick;

	static StringBuilder sb = new StringBuilder();
	static void comb(int cnt, int start) {
		if(cnt == L) {
			int mo=0, za=0;
			for(int i=0;i<L;i++) {
				if(pick[i]=='a' ||pick[i]=='e'||pick[i]=='i'||pick[i]=='o'||pick[i]=='u')
					mo++;
				else
					za++;
			}
			if(mo>=1 && za>=2) {
				for(int i=0;i<L;i++) {
					sb.append(pick[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for(int i=start;i<C;i++) {
			pick[cnt] = dic[i];
			comb(cnt+1, i+1);
		}
		
	}

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
	
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        dic = new char[C];
        pick = new char[L];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
        	dic[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(dic);
        
        comb(0,0);
        System.out.println(sb);
        
	}
	
}
