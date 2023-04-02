import java.io.*;
import java.util.*;
public class Main_14938_서강라운드 {

    static int n,m,r;

    static List<int[]>[] point;
    static int[] item;

    static int answer = Integer.MIN_VALUE;

    static void bfs(int start){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
        boolean[] vis = new boolean[n+1];
        q.offer(new int[] {start,0});
        int count =0;


        while (!q.isEmpty()){
            int[] polled = q.poll();
            int city = polled[0];
            int dis = polled[1];
            if(vis[city]) continue;
            vis[city] = true;
            count += item[city];

            for(int[] tmp : point[city]){
                if(!vis[tmp[0]] && tmp[1] + dis <= m){
                    q.offer(new int[] {tmp[0],tmp[1] + dis});
                }
            }
        }
        answer = Integer.max(answer,count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        point = new List[n+1];
        item = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            item[i] = Integer.parseInt(st.nextToken());
            point[i] = new ArrayList<>();
        }

        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            point[a].add(new int[] {b, l});
            point[b].add(new int[] {a, l});
        }

        for(int i=1;i<=n;i++){
            bfs(i);
        }
        System.out.println(answer);

    }
}
