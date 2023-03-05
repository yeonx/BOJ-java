import java.io.*;
import java.util.*;

public class Main_1 {

    static int N,answer;

    static void solve(){
        int num = N;

        while(num>0){
            if(num%5==0){
                answer += num/5;
                return;
            }else{
                answer ++;
                num -=3;
            }
            if(num==0) return;
        }
        answer = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        solve();

        System.out.println(answer);

    }
}
