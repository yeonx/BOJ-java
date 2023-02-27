import java.io.*;
import java.util.*;

public class Main_bj_17471_게리맨더링_서울_20반_이연희 {

    static int N;
    static int[] population;
    static boolean[] vis, bfsVis;
    static List<Integer>[] group;

    static int A,B,answer=Integer.MAX_VALUE,flag=0;

    static void bfsA(int start){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        bfsVis[start] = true;

        A=0;
        while (!q.isEmpty()){
            int stand = q.poll();
            A += population[stand];
            for(int index: group[stand]){
                if(!bfsVis[index] && vis[index]){
                    bfsVis[index] = true;
                    q.offer(index);
                }
            }
        }
    }

    static void bfsB(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        bfsVis[start] = true;

        B=0;
        while (!q.isEmpty()) {
            int stand = q.poll();
            B += population[stand];
            for (int index : group[stand]) {
                if (!bfsVis[index] && !vis[index]) {
                    bfsVis[index] = true;
                    q.offer(index);
                }
            }
        }
    }
    static void subs(int index){
        if(index==N+1){
            bfsVis = new boolean[N+1];
            A=0;B=0;

            for(int i=1;i<=N;i++){
                if(vis[i]){
                    bfsA(i);
                    break;
                }
            }

            for(int i=1;i<=N;i++){
                if (!vis[i]) {
                    bfsB(i);
                    break;
                }
            }

            for(int i=1;i<=N;i++){
                if (!bfsVis[i]) {
                    return;
                }
            }

            flag=1;
            answer = Math.min(answer, Math.abs(A-B));
            return;
        }

        vis[index] = true;
        subs(index+1);

        vis[index] = false;
        subs(index+1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        population = new int[N+1];
        group = new List[N+1];
        vis = new boolean[N+1];

        for(int i=1;i<=N;i++) {
            group[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int pointCount = Integer.parseInt(st.nextToken());
            for(int j=0;j<pointCount;j++){
                group[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        subs(1);

        if (flag==0){
            System.out.println(-1);
        } else{
            System.out.println(answer);
        }

    }
}
