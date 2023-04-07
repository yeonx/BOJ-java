import java.io.*;
import java.util.*;

public class Main {

    static class Shark {
        int y;
        int x;
        int s; //속력
        int d; //방향
        int z; //크기
        public Shark(int y, int x, int s, int d, int z){
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static int R,C,M;
    static List<Shark> sharks = new ArrayList<>();
    static int[] dy = {0,-1,1,0,0};
    static int[] dx = {0,0,0,1,-1};
    static int answer = 0;
    static void fishing(int fisherman){
        for(Shark s : sharks){
            if(s.x==fisherman){
                answer+=s.z;
                sharks.remove(s);
                return;
            }
        }
    }
    static void movingSharks(){
        for(Shark s: sharks) {
            for(int move=0;move<s.s;move++) {
                s.y = s.y + dy[s.d];
                s.x = s.x + dx[s.d];
                if (s.y == 0) {
                    s.y = 2;
                    s.d = 2;
                } else if (s.y == R + 1) {
                    s.y = R - 1;
                    s.d = 1;
                } else if (s.x == 0) {
                    s.x = 2;
                    s.d = 3;
                } else if (s.x == C + 1) {
                    s.x = C - 1;
                    s.d = 4;
                }
            }
        }
    }

    static void eatShark(){
        Shark preShark = sharks.get(0);
        List<Shark> removed = new ArrayList<>();
        int index =0;
        for (Shark s: sharks) {
            if(index==0) {
                index++;
                continue;
            }
            if(s.y==preShark.y && s.x==preShark.x){
                if(s.z > preShark.z) {
                    removed.add(preShark);
                    preShark = s;
                }
                else removed.add(s);
            }
            else preShark = s;
        }

        sharks.removeAll(removed);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks.add( new Shark(y,x,s,d,z));
        }

        for(int fisherman=1;fisherman<=C && sharks.size()!=0 ;fisherman++){
            Collections.sort(sharks, (Shark s1, Shark s2) -> {
                if(s1.y==s2.y) return s1.x-s2.x;
                return s1.y-s2.y;
            });
            eatShark();
            fishing(fisherman);
            movingSharks();
        }

        System.out.println(answer);
    }
}
