import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[3];

        while(true){
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<3;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0]==0) break;

            Arrays.sort(arr);

            if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1])
                System.out.println("right");
            else
                System.out.println("wrong");
            
        }
    }
}
