package gold;

import java.io.*;
import java.util.*;

public class Main_2252_줄세우기 {
    static int N,M;
    static List<Integer>[] people;
    static boolean[] isFront,vis;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int person){

        for(int p:people[person]){
            if(!vis[p]){
                dfs(p);
                vis[p]=true;
            }
        }
        answer.append(person + " ");
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

        for(int i=0;i<=N;i++){
            people[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            isFront[A] = true;
            people[B].add(A);
        }
        for(int i=1;i<=N;i++){
            if(!isFront[i] && !vis[i]) dfs(i);
        }
        System.out.println(answer);
    }
}

