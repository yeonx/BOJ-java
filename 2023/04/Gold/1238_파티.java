import java.io.*;
import java.util.*;

public class Main_1238_파티 {

    static List<int[]>[] home;

    static boolean[] vis;
    static int N, M, X;
    static int maxTime = Integer.MIN_VALUE;

    static void bfs(int stand){
        vis = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
        q.offer(new int[] {stand, 0});
        dist[stand] = 0;

        int minTime = 0;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            int city = polled[0];
            int time = polled[1];
            if(vis[city]) continue;
            vis[city] = true;

            if(city==X){
                minTime = time;
                break;
            }

            for(int[] tmp : home[city]){
                if(!vis[tmp[0]] && dist[tmp[0]] > tmp[1] + time) {
                    dist[tmp[0]] = tmp[1] + time;
                    q.offer(new int[]{tmp[0], tmp[1] + time});
                }
            }
        }

        vis = new boolean[N+1];
        q = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
        q.offer(new int[] {X, minTime});
        dist[X] = 0;
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!q.isEmpty()){
            int[] polled = q.poll();
            int city = polled[0];
            int time = polled[1];
            if(vis[city]) continue;
            vis[city] = true;

            if(city==stand){
                maxTime = Integer.max(maxTime, time);
                return;
            }

            for(int[] tmp : home[city]){
                if(!vis[tmp[0]] && dist[tmp[0]] > tmp[1] + time) {
                    dist[tmp[0]] = tmp[1] + time;
                    q.offer(new int[]{tmp[0], dist[tmp[0]]});

                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        home = new List[N+1];

        for(int i=1;i<=N;i++){
            home[i]= new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            home[start].add(new int[] {end, time});
        }

        for(int i=1;i<=N;i++){
            if(i==X) continue;
            bfs(i);
        }

        System.out.println(maxTime);

    }

}
