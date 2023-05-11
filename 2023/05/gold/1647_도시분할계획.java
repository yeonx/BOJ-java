import java.io.*;
import java.util.*;

public class Main_1647_도시분할계획 {
    static int V, E;
    static List<int[]>[] node;
    static int[] dist, road;

    static void bfs(){
        boolean[] vis = new boolean[V+1];
        dist = new int[V+1];
        road = new int[V+1];
        Arrays.fill(vis, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(road, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>( (o1,o2) -> {
            return o1[1]-o2[1];
        });
        q.offer(new int[] {1,0});
        dist[1] = 0;
        road[1] = 0;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            int num = polled[0];
            int cost = polled[1];
            if (vis[num]) continue;
            vis[num] = true;

            for(int[] tmp: node[num]){
                int nextNum = tmp[0];
                int nextCost = tmp[1];
                if(!vis[nextNum] && road[nextNum] > nextCost) {
                    dist[nextNum] = cost+nextCost;
                    road[nextNum] = nextCost;
                    q.offer(new int[] {nextNum, nextCost});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        node = new List[V+1];

        for(int i=0;i<=V;i++){
            node[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            node[n1].add(new int[] {n2, cost});
            node[n2].add(new int[] {n1, cost});
        }

        bfs();

        int answer=0;

        Arrays.sort(road);
        for(int i=0;i<V-1;i++){
            answer+=road[i];
        }
        System.out.println(answer);

    }
}
