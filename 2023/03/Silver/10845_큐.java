import java.io.*;
import java.util.*;

public class Main_1 {

    static int N;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int number=-1;
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if(st.hasMoreTokens())
                number = Integer.parseInt(st.nextToken());

           if(command.equals("push")) q.offer(number);
           else if(command.equals("front")) sb.append((q.isEmpty() ? "-1" : q.peekFirst()) + "\n");
           else if(command.equals("back")) sb.append((q.isEmpty() ? "-1" : q.peekLast())+ "\n");
           else if(command.equals("empty")) sb.append((q.isEmpty() ? "1":"0") + "\n");
           else if(command.equals("pop")) sb.append((q.isEmpty() ? "-1" :q.poll()) + "\n");
           else if(command.equals("size")) sb.append(q.size() + "\n");
        }

        System.out.print(sb);
    }
}
