import java.io.*;
import java.util.*;

public class Main_1 {

    static int answer;
    static int N;
    static int[] arr;

    static void find(int number){
        if(number==1) return;
        for(int i=2;i<number;i++){
            if(number%i==0){
                return;
            }
        }
        answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            find(arr[i]);
        }

        System.out.println(answer);

    }
}
