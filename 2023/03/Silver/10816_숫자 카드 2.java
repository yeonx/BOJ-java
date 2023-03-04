import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer,Integer> arr = new HashMap<>();

        int N,M;

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr.put(tmp, arr.containsKey(tmp) ? arr.get(tmp)+1 : 1);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int number = Integer.parseInt(st.nextToken());
            sb.append((arr.containsKey(number) ? arr.get(number) : 0)+" ");
        }

        System.out.print(sb);
    }
}
