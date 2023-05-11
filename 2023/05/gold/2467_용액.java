import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2467_용액 {
    static int N;
    static int[] arr;
    static long minDiff = Long.MAX_VALUE;
    static StringBuilder answer;

    static void twoPoint(int left, int right){
        if(left==right) return;
        long sum = arr[left] + arr[right];
        if(Math.abs(sum) < minDiff) {
            answer = new StringBuilder();
            answer.append(arr[left] + " " + arr[right]);
            minDiff = Math.abs(sum);
        }
        if(sum==0) return;
        else if(sum<0) left++;
        else right--;
        twoPoint(left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        twoPoint(0,N-1);
        System.out.println(answer);
    }
}
