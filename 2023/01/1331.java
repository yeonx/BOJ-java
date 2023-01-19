import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static int alToNum(char stand){
        return stand - 'A';
    }

    public static void main(String[] args) throws IOException {

        int[] di = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dj = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[][] vis = new int[6][6];
        int flg = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stand = br.readLine();
        int alStand = alToNum(stand.charAt(0));
        int numStand = Integer.parseInt(String.valueOf(stand.charAt(1))) - 1;

        int alStart = alStand;
        int numStart = numStand;

        vis[alStart][numStart] = 1;

        for(int n=0 ; n<35 ; n++){
            String next = br.readLine();

            int alNext = alToNum(next.charAt(0));
            int numNext = Integer.parseInt(String.valueOf(next.charAt(1))) - 1;

            if(vis[alNext][numNext] == 1){
                flg = -1;
                break;
            }
            vis[alNext][numNext] = 1;

            flg = 0;
            for(int i=0 ; i<8 ; i++){
                if((alStand + di[i] == alNext) && (numStand + dj[i] == numNext)){
                    flg=1;
                    break;
                }
            }

            if(flg==1){
                alStand = alNext;
                numStand = numNext;
            }
            else{
                flg = -1;
                break;
            }
        }

        if(flg==1){
            for(int i=0 ; i<8 ; i++){
                flg = -1;
                if(alStand + di[i] == alStart && numStand + dj[i] == numStart){
                    flg=1;
                    break;
                }
            }
        }


        if(flg==-1){
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }

    }
}
