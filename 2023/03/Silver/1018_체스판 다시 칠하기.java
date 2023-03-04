import java.io.*;
import java.util.*;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N,M;
        int[][] map;

        int count1=0, count2=0;
        int answer = Integer.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                if(str.charAt(j) == 'W')
                    map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                count1=count2=0;
                for(int h=i;h<8+i;h++){
                    for(int w=j;w<8+j;w++){
                        if((h+w)%2==0 && map[h][w] == 1){
                            count2++;
                        } else if((h+w)%2==0 && map[h][w] == 0){
                            count1 ++;
                        } else if((h+w)%2==1 && map[h][w] == 1){
                            count1 ++;
                        } else if((h+w)%2==1 && map[h][w] == 0){
                            count2 ++;
                        }
                    }
                }
                answer = Math.min(answer, Math.min(count1, count2));
            }
        }
        System.out.println(answer);
    }
}
