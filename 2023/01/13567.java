import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());

        int nowI=0, nowJ=0;
        int nowT=0;

        int flg=0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int distance  = Integer.parseInt(st.nextToken());

            if(command.equals("MOVE")){
                int tmpI = (di[nowT]*distance) + nowI;
                int tmpJ = (dj[nowT]*distance) + nowJ;

                if(0<=tmpI && tmpI<=N && 0<=tmpJ && tmpJ<=N){
                    nowI=tmpI;
                    nowJ=tmpJ;
                }
                else{
                    flg=-1;
                    break;
                }
            } else if (distance==0) {
                nowT = (nowT+1)%4;
            } else if (distance==1) {
                nowT = (nowT+4-1)%4;
            }
        }
        if(flg==-1){
            System.out.println("-1");
        }
        else{
            System.out.println(nowJ+" "+nowI);
        }
    }
}
