import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int p, s,answer;
    static String dna;
    static int[] minDnaSet = new int[4], dnaSet = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < minDnaSet.length ; i++) minDnaSet[i] = Integer.parseInt(st.nextToken());

        solve(); 
        System.out.println(answer);
    }

    static void solve(){
        for(int i=0;i<s;i++){
            dnaSet[dnaToIndex(dna.charAt(i))]++;
        }
        check();
        for(int i=0;i+s<p;i++){
            dnaSet[dnaToIndex(dna.charAt(i))]--;
            dnaSet[dnaToIndex(dna.charAt(i+s))]++;
            check();
        }
    }

    static void check(){
        for(int i=0;i<4;i++){
            if(dnaSet[i] < minDnaSet[i])
                return;
        }
        answer++;
    }

    static int dnaToIndex(char dna){
        if(dna == 'A'){
            return 0;
        } else if (dna == 'C') {
            return 1;
        } else if (dna == 'G') {
            return 2;
        } else {
            return 3;
        }
    }
}
