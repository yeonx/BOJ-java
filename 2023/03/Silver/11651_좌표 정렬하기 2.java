import java.io.*;
import java.util.*;

public class Main_1 {

    static class Point{
        int y;
        int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] point = new Point[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            point[i] = new Point(y, x);
        }

        Arrays.sort(point, (o1,o2) -> {
            if(o1.x==o2.x) return o1.y - o2.y;
            return o1.x- o2.x;
        });

        for(int i=0;i<N;i++){
            System.out.println(point[i].y +" " +point[i].x);
        }

    }
}
