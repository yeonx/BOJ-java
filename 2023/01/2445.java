import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        int N = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            sb = new StringBuilder();
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            for(int j= (N-i)*2-1;j>=0;j--){
                sb.append(" ");
            }
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            System.out.println(sb);
        }

        for(int i=N-1;i>=0;i--){
            sb = new StringBuilder();
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            for(int j= (N-i)*2-1;j>=0;j--){
                sb.append(" ");
            }
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}
