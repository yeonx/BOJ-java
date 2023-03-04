import java.io.*;
import java.util.*;

public class Main_1 {

    static int N, K;
    static int s;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void find(int stand){
        int tmp = (stand + K - 1) % list.size();
        if(list.size()==1){
            sb.append(list.get(tmp)+ ">");
            list.remove(tmp);
            return;
        }
        sb.append(list.get(tmp)+ ", ");
        list.remove(tmp);
        s=tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        sb.append("<");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            list.add(i);
        }

        while(!list.isEmpty()){
            find(s);
        }

        System.out.println(sb);

    }
}
