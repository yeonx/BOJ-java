import java.io.*;
import java.util.*;

public class Main_1865_웜홀 {

    static List<int[]>[] road;
    static int N;

    static final int INF = 1000000000;

    static boolean bellmanFord(){

        int[] bellFord = new int[N+1];
        Arrays.fill(bellFord, INF);

        boolean update;

        bellFord[1] = 0;

        for(int cnt=1;cnt<N;cnt++){
            update = false;
            for(int startCity = 1 ; startCity<=N ; startCity++){
                for(int[] tmp : road[startCity]){
                    if(bellFord[tmp[0]] > bellFord[startCity] + tmp[1]){
                        bellFord[tmp[0]] = bellFord[startCity] + tmp[1];
                        update = true;
                    }
                }
            }
            if(!update) break;
        }

        for(int startCity = 1 ; startCity<=N ; startCity++){
            for(int[] tmp : road[startCity]){
                if(bellFord[tmp[0]] > bellFord[startCity] + tmp[1]){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int testCase=0 ; testCase<T ; testCase++ ) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            road = new List[N+1];

            for(int i=1;i<=N;i++) {
                road[i] = new ArrayList<>();
            }

            for(int m=0 ; m<M ; m++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                road[s].add(new int[] {e, t});
                road[e].add(new int[] {s, t});
            }

            for(int w=0 ; w<W ; w++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                road[s].add(new int[] {e, t*(-1)});
            }

            String Answer = "NO";
            if(bellmanFord()) {
                Answer = "YES";
            }

            sb.append(Answer + "\n");
        }

        System.out.println(sb);
    }

}
