import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(true){
            String tmp = br.readLine();
            if(tmp.equals("0")) break;

            int flg=0;
            for(int i=0;i<tmp.length()/2;i++){
                if(tmp.charAt(i)!=tmp.charAt(tmp.length()-1-i)){
                    sb.append("no\n");
                    flg=1;
                    break;
                }
            }
            if(flg==0)
                sb.append("yes\n");
        }
        System.out.print(sb);
    }
}
