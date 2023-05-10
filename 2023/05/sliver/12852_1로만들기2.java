import java.io.*;
import java.util.*;

public class Main_12852_1로만들기2 {

    static int c = Integer.MAX_VALUE;
    static int N;
    static StringBuilder sb = new StringBuilder();

    static int[] threeDiv(int num, int[] arr){
        int[] a = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            a[i] = arr[i];
        }
        a[arr.length] = num/3;
        return a;
    }
    static int[] twoDiv(int num, int[] arr){
        int[] a = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            a[i] = arr[i];
        }
        a[arr.length] = num/2;
        return a;
    }

    static int[] oneDif(int num, int[] arr){
        int[] a = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            a[i] = arr[i];
        }
        a[arr.length] = num-1;
        return a;
    }

    static void solve(int num,int count, int[] arr){
        if(count > c) return;
        if(num==1 && count < c){
            c = count;
            sb = new StringBuilder();
            sb.append(c + "\n" + N + " ");
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i] + " ");
            }
            return;
        }

        if(num%3==0){
            solve(num/3,count+1, threeDiv(num, arr));
        }
        if(num%2==0){
            solve(num/2,count+1, twoDiv(num, arr));
        }
        solve(num-1,count+1, oneDif(num, arr));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = {};
        solve(N, 0, arr);
        System.out.println(sb);

    }
}
