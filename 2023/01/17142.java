import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {

    static int N;
    static int M;
    static int[][] num;
    static boolean[] visited;
    static int zeroNum;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};

    static int[] combinationArr;
    static int answer = 2500;

    static void combination(int start, int r, int[] virusI, int[] virusJ){
        if(r==0){
            int[] standArr = returnOutput(visited);
            findMinAnswer(standArr, virusI, virusJ);
            return;
        }

        for(int i=start ; i<combinationArr.length ; i++){
            visited[i] = true;
            combination(i+1,r-1, virusI, virusJ);
            visited[i] = false;
        }
    }

    static void findMinAnswer(int[] standArr, int[] virusI, int[] virusJ){
        int[][] tmpArr = new int[num.length][num[0].length];

        int cnt=0;
        int count=-1;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tmpArr[i][j] = num[i][j];
            }
        }
        for(int i=0;i<M;i++){
            tmpArr[virusI[standArr[i]]][virusJ[standArr[i]]] = -2;
        }
        while (true){
            int flg =0 ;
            count++;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if( ( count ==0 && tmpArr[i][j] == -2) || ( count!=0 && tmpArr[i][j] == count )){
                        for(int d=0;d<4;d++){
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            if( 0<=ni && ni<N && 0<=nj && nj<N && (tmpArr[ni][nj] == 0 || tmpArr[ni][nj] == -3)){
                                if(tmpArr[ni][nj] == 0) cnt++;
                                tmpArr[ni][nj] = count+1;
                                flg=1;
                            }
                            if(cnt==zeroNum){
                                answer = min(answer,count+1);
                                return;
                            }
                        }
                    }
                }
            }
            if(flg==0){
                return;
            }
        }
    }

    static int[] returnOutput(boolean[] visited){
        int[] returnOutput = new int[M];
        int cnt=0;
        for(int i=0 ; i< combinationArr.length ; i++){
            if(visited[i]==true){
                returnOutput[cnt++] = combinationArr[i];
            }
        }
        return returnOutput;
    }

    static void zeroToVirusNum(int virusNum){
        combinationArr = new int[virusNum];
        for(int i=0;i<virusNum;i++){
            combinationArr[i] = i;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int pos = input.indexOf(" ");
        N = Integer.parseInt(input.substring(0,pos));
        M = Integer.parseInt(input.substring(pos+1));

        int[] virusI = new int[1];
        int[] virusJ = new int[1];
        int virusNum=0;
        zeroNum=0;
        num = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<N ; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());

                if(num[i][j]==2){
                    num[i][j] = -3; //바이러스
                    int[] NewVirusI = Arrays.copyOf(virusI,virusNum+1);
                    NewVirusI[virusNum] = i;
                    int[] NewVirusJ = Arrays.copyOf(virusJ,virusNum+1);
                    NewVirusJ[virusNum] = j;
                    virusNum++;
                    virusI = NewVirusI;
                    virusJ = NewVirusJ;
                } else if(num[i][j]==0){
                    zeroNum++;
                } else if(num[i][j]==1){
                    num[i][j] = -1; //벽
                }
            }
        }

        if(zeroNum==0){
            answer=0;
        }else{
            visited = new boolean[virusNum];
            zeroToVirusNum(virusNum); // 바이러스 수로 배열 만들기
            combination(0, M, virusI, virusJ);
            if(answer==2500)
                answer = -1;
        }

        System.out.println(answer);
    }
}
