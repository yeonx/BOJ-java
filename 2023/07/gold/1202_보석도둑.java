package gold;

import java.io.*;
import java.util.*;

public class Main_1202_보석도둑 {
    static int N, K;
    static PriorityQueue<Dia> diamondQ;
    static PriorityQueue<Dia> di;
    static int[] bag;

    static class Dia{
        int M;
        int V;
        public Dia(int M, int V){
            this.M = M;
            this.V = V;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bag = new int[K];

        di = new PriorityQueue<>( (o1,o2) ->{
            if(o1.M > o2.M) return 1;
            else if(o1.M < o2.M)  return -1;
            return 0;}
        );

        diamondQ = new PriorityQueue<>( (o1,o2) ->{
            if(o1.V > o2.V) return -1; // 앞에를 우선순위 두고 싶으면 음수
            else return 1; // 아니면 양수
        }

        );

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Dia dia = new Dia(m,v);
            di.offer(dia);
        }

        for(int i=0;i<K;i++){
            int c = Integer.parseInt(br.readLine());
            bag[i] = c;
        }

        Arrays.sort(bag);

        Long answer=0L;

        for(int i=0;i<K;i++){
            while (!di.isEmpty()){
                Dia dia = di.poll();
                if(dia.M <= bag[i]) {
                    diamondQ.offer(dia);
                }
                else {
                    di.offer(dia);
                    break;
                }
            }
            if(!diamondQ.isEmpty()) {
                Dia dia = diamondQ.poll();
                answer += dia.V;
            }
        }
        System.out.println(answer);

    }
}
