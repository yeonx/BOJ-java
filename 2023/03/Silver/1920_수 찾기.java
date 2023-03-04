import java.io.*;
import java.util.*;

public class Main_1 {

    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void find(int start, int end, int number){

        if(start > end) {
            sb.append("0\n");
            return;
        }

        int half = (start + end) / 2;

        if(arr[half] == number){
            sb.append("1\n");
            return;
        }

        if(arr[half] > number){
            find(start, half-1, number);
        } else{
            find(half+1, end, number);
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,M;

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int number = Integer.parseInt(st.nextToken());
            find(0, N-1, number);
        }

        System.out.print(sb);
    }
}
