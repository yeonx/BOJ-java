import java.io.*;
import java.util.*;

public class Main_2015 {

    static int N,K;
    static long answer;
    static int[] arr;
    static Map<Integer, Long> map= new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

            if(arr[i] == K){
                answer++;
            }

            if(map.containsKey(arr[i]-K)){
                answer += map.get(arr[i]-K);
            }

            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1L);
            }

        }

        System.out.println(answer);
    }
}
