import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture {
    int start;
    int end;
    Lecture(int start, int end){
        this.start = start;
        this.end  = end;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        int N,M,S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Lecture[] lectures = new Lecture[N];
        for(int t=0;t<N;t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            lectures[t] = new Lecture(M, S);
        }
        Arrays.sort(lectures,(l1,l2)->{
            if(l1.start == l2.start) return l1.end - l2.end;
            return l1.start - l2.start;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);
        for(int i=1;i<N;i++){
            if(lectures[i].start >= pq.peek()){
                pq.poll();
            }
            pq.offer(lectures[i].end);
        }
        System.out.println(pq.size());
    }
}
