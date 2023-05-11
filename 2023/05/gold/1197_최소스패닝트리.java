import java.io.*;
import java.util.*;

public class Main_1197_최소스패닝트리 {
    static int V, E;
    static List<int[]>[] node;
    static int[] dist;

    static void bfs(){
        boolean[] vis = new boolean[V+1];
        dist = new int[V+1];
        Arrays.fill(vis, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>( (o1,o2) -> {
            return o1[1]-o2[1];
        });
        q.offer(new int[] {1,0});
        dist[1] = 0;

        while (!q.isEmpty()){
            int[] polled = q.poll();
            int num = polled[0];
            if (vis[num]) continue;
            vis[num] = true;

            for(int[] tmp: node[num]){
                int nextNum = tmp[0];
                int cost = tmp[1];
                if(!vis[nextNum] && dist[nextNum] > cost) {
                    dist[nextNum] = cost;
                    q.offer(new int[] {nextNum, cost});
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
        for(int i=1;i<=V;i++){
            answer+=dist[i];
        }
        System.out.println(answer);

    }
}
