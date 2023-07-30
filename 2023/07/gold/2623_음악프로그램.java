package gold;

import java.io.*;
import java.util.*;

public class Main_2623_음악프로그램 {
    static int N,M;
    static List<Integer>[] people;
    static boolean[] isFront,vis,visCycle;
    static StringBuilder answer = new StringBuilder();
    static boolean canAnswer = true;

    static void check(int number){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(number);
        visCycle[number] = true;
        while (!q.isEmpty()){
            int polled = q.poll();
            for(int p:people[polled]){
                if(p==number) {
                    canAnswer = false;
                    return;
                }
                if(!visCycle[p]){
                    visCycle[p] = true;
                    q.offer(p);
                }
            }
        }
    }

    static void dfs(int person){
        for(int p:people[person]){
            if(!vis[p]){
                vis[p]=true;
                dfs(p);
            }
        }
        answer.append(person + "\n");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new ArrayList[N+1];
        isFront = new boolean[N+1];
        vis = new boolean[N+1];
        visCycle = new boolean[N+1];

        for(int i=0;i<=N;i++){
            people[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int pre = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()){
                int next = Integer.parseInt(st.nextToken());
                isFront[pre]=true;
                if(!people[next].contains(pre))
                    people[next].add(pre);
                pre = next;
            }
        }
        for(int i=1;i<=N;i++){
            Arrays.fill(visCycle, false);
            check(i);
            if (!canAnswer){
                System.out.println(0);
                return;
            }
        }
        for(int i=1;i<=N;i++){
            if(!isFront[i] && !vis[i]) {
                vis[i] = true;
                dfs(i);
            }
        }
        System.out.print(answer);
    }
}

