package day0220;

import java.util.*;
import java.io.*;

public class Main_bj_1074_Z_서울_20반_이연희 {
	
	
    static int solve(int r, int c, int size, int count){
        if(size==1) return count;
        int half = size/2;
        int point = size*size/4;
        
        if( r<half && c<half){
            count+=solve(r, c, half, point*0);
        } else if(r<half && c>=half){
            count+=solve(r, c-half, half, point*1);
        } else if(r>=half && c<half){
            count+=solve(r-half, c, half, point*2);
        } else if(r>=half && c>=half){
            count+=solve(r-half, c-half, half, point*3);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(solve(r,c, (int)Math.pow(2,N),0));

    }
}
