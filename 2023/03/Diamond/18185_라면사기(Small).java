import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18185 {

    static int N, answer=0;
    static int[] arr, noodle = new int[3];

    static void checkSeven(){
        int min = Math.min(noodle[2], Math.min(noodle[1],noodle[0]));
        answer += min*7;
        for(int i=0;i<3;i++) noodle[i] -= min;
    }
    static void checkFive(int min){
        answer+=5*min;
        noodle[2] -= min;
        noodle[1] -= min;
    }

    static void slide(int stand){

        if(noodle[1]>noodle[0]){
            checkFive(Math.min(noodle[2], noodle[1]-noodle[0]));
            checkSeven();
        }
        else {
            checkSeven();
            checkFive(Math.min(noodle[2],noodle[1]));
        }

        answer+=noodle[2]*3;

        noodle[2] = noodle[1];
        noodle[1] = noodle[0];
        noodle[0] = arr[stand];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N+3];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N+3;i++){
            slide(i);
        }

        sb.append(answer);
        System.out.println(sb);

    }
}
