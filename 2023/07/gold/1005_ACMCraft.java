package gold;

import java.io.*;
import java.util.*;

public class Main_1005_ACMCraft {
    static int N,K;
    static int[] cost,preCost;
    static List<Integer>[] graph;
    static boolean[] vis;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test=0;test<T;test++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cost = new int[N+1];
            preCost = new int[N+1];
            graph = new ArrayList[N+1];
            vis = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                graph[i] = new ArrayList<>();
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y].add(x);
            }
            int W = Integer.parseInt(br.readLine());
            dfs(W);
            answer.append(preCost[W] + "\n");
        }
        System.out.print(answer);
    }
    static void dfs(int point){
        if(graph[point].isEmpty()){
            vis[point] = true;
            preCost[point] = cost[point];
            return;
        }
        for(int p: graph[point]){
            if(!vis[p]) {
                dfs(p);
                vis[p] = true;
            }
            preCost[point] = Math.max(preCost[point], preCost[p]+cost[point]);
        }
    }
}
