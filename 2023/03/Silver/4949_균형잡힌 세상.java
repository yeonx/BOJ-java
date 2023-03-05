import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int flg;

        ArrayDeque<Character> q;

        while (true){
            flg=0;
            String str = br.readLine();
            q = new ArrayDeque<>();
            if(str.equals(".")) break;

            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '[') q.offerLast(str.charAt(i));
                else if(str.charAt(i) == ')'){
                    if(q.isEmpty()) {
                        flg=-1;
                        break;
                    }
                    char tmp = q.pollLast();
                    if(tmp!='(') flg=-1;
                } else if(str.charAt(i) == ']'){
                    if(q.isEmpty()) {
                        flg=-1;
                        break;
                    }
                    char tmp = q.pollLast();
                    if(tmp!='[') flg=-1;
                }
            }
            if(!q.isEmpty()) flg = -1;

            if(flg==-1)
                sb.append("no\n");
            else
                sb.append("yes\n");
        }
        System.out.print(sb);

    }
}
