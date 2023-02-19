import java.io.*;
import java.util.*;

public class Main_bj_3040_백설공주와일곱난쟁이_서울_20반_이연희 {

    static int[] arr = new int[9], di = new int[2];
    static int[] notSeven = new int[2];
    static int diff;

    static void comb(int cnt, int start){
        if(cnt == 2){
            if(arr[di[0]]+arr[di[1]]==diff){
                notSeven[0] = di[0];
                notSeven[1] = di[1];
            }
            return;
        }

        for(int i=start;i<9;i++){
            di[cnt] = i;
            comb(cnt+1,i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        diff = sum - 100;
        comb(0,0);

        for(int i=0;i<9;i++){
            if(i == notSeven[0] || i==notSeven[1]) continue;
            System.out.println(arr[i]);
        }

    }
}
