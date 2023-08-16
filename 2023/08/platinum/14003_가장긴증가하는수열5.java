package platinum;

import java.io.*;
import java.util.*;

public class Main_14003_가장긴증가하는수열5 {
    static int N,cnt=0;
    static int[] arr, check, list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new int[N];
        check = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(i==0){
                list[cnt] = arr[i];
                check[i] = cnt;
                cnt++;
            } else if (list[cnt-1] < arr[i]) {
                list[cnt] = arr[i];
                check[i] = cnt;
                cnt++;
            } else {
                int point = findPoint(0, cnt-1, arr[i]);
                list[point] = arr[i];
                check[i] = point;
            }
        }

        sb.append(cnt + "\n");
        cnt--;
        for(int i=N-1;i>=0 && cnt >=0 ;i--){
            if(check[i]==cnt) {
                stack.offerFirst(arr[i]);
                cnt--;
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst() + " ");
        }

        System.out.print(sb);
    }

    static int findPoint(int start, int end, int target){
        while (start < end){
            int mid = (start+end)/2;

            if(list[mid] < target) start = mid+1;
            else end = mid;

        }
        return start;
    }
}
