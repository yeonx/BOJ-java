import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            int X, Y;

            if (N % H == 0) {
                Y = H * 100;
                X = N / H;
            }
            else {
                Y = (N % H) * 100;
                X = (N / H) + 1;
            }

            int XXYY = Y + X;	//최종 호수
            sb.append(XXYY + "\n");
        }
        System.out.println(sb);
    }
}
