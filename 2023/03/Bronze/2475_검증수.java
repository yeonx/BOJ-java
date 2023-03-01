import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int sum=0;
        for(int i=0;i<5;i++){
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp*tmp;
        }

        System.out.println(sum%10);
    }
}
