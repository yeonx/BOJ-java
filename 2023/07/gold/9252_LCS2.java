package gold;

import java.util.*;
import java.io.*;

public class Main_9252_LCS2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        String str1 = "1" + br.readLine();
        String str2 = "2" + br.readLine();

        int[][] lcs = new int[str1.length()][str2.length()];

        for(int i=0;i<str1.length();i++){
            Arrays.fill(lcs[i],0);
        }

        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }

        String str = "";
        int i=str1.length()-1;
        int j=str2.length()-1;
        while(lcs[i][j]>0){
            if(lcs[i][j]==lcs[i-1][j]){
                i--;
            } else if(lcs[i][j]==lcs[i][j-1]){
                j--;
            } else{
                str = str1.charAt(i) + str;
                i--;
                j--;
            }
        }

        answer.append(lcs[str1.length()-1][str2.length()-1] + "\n");
        if(lcs[str1.length()-1][str2.length()-1]!=0){
            answer.append(str);
        }
        System.out.println(answer);
    }
}
