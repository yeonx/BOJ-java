import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Long sum=1l;
        for(int i=0;i<3;i++){
            int tmp = Integer.parseInt(br.readLine());
            sum *= tmp;
        }

        String num = sum.toString();

        int[] arr = new int[10];

        for(int i=0;i<num.length();i++){
            arr[i]=0;
        }

        for(int i=0;i<num.length();i++){
            arr[num.charAt(i)-'0']++;
        }

        for(int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
    }
}
