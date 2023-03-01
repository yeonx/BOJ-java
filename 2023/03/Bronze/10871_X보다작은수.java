import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp < X) sb.append(tmp + " ");

        }
        System.out.println(sb);

    }
}
