import java.io.*;
import java.util.*;

public class Main_20040_사이클게임 {
    static int n,m,answer=0;
    static int[] start;

    static int find(int x) {
        if(start[x] == x) return x;
        return start[x] = find(start[x]);
    }
    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return false;
        }

        if(x <= y) start[y] = x;
        else start[x] = y;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        start = new int[n];
        for(int i=0;i<n;i++) {
            start[i] = i;
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boolean is = union(a, b);
            if(!is && answer==0){
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
