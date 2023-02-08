import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class MeetingRoom{
    int start;
    int end;
    MeetingRoom(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int start, end;
        MeetingRoom[] meetingRooms = new MeetingRoom[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meetingRooms[i] = new MeetingRoom(start,end);
        }

        Arrays.sort(meetingRooms, (l1,l2)->{
            if(l1.start==l2.start) return l1.end - l2.end;
            return l1.start -l2.start;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetingRooms[0].end);
        for(int i=1;i<N;i++){
            if(meetingRooms[i].start >= pq.peek()){
                pq.poll();
            }
            pq.offer(meetingRooms[i].end);
        }
        System.out.println(pq.size());

    }
}
