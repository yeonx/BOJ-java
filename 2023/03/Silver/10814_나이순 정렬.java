import java.io.*;
import java.util.*;

public class Main_1 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    static Member[] members;

    static class Member{
        int age;
        String name;
        public Member(int age, String name){
            this.age  = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        members = new Member[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
           members[i] = new Member(age, name);
        }

        Arrays.sort(members, (o1,o2) -> {
            return o1.age - o2.age;
        });

        for(int i=0;i<N;i++){
            sb.append(members[i].age + " " + members[i].name + "\n");
        }

        System.out.print(sb);
    }
}
