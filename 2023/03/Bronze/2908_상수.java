import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        StringBuilder A = new StringBuilder(st.nextToken());
        StringBuilder B = new StringBuilder(st.nextToken());

        A.reverse();
        B.reverse();

        String aStr = A.toString();
        String bStr = B.toString();

        int a = 0, b=0;

        for(int i=0;i<aStr.length();i++){
            a = a*10 + (aStr.charAt(i)-'0');
        }

        for(int i=0;i<bStr.length();i++){
            b = b*10 + (bStr.charAt(i)-'0');
        }

        System.out.println(Math.max(a,b));
    }
}
