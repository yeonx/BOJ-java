import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int pos = input.indexOf(" ");

        int N = Integer.parseInt(input.substring(0,pos));
        int M = Integer.parseInt(input.substring(pos+1));
        int[][] ice = new int[N][N];
        int total = 0;
        int a,b;

        for(int i=0;i<M;i++) {
            String line = br.readLine();
            pos = line.indexOf(" ");
            a = Integer.parseInt(line.substring(0,pos));
            b = Integer.parseInt(line.substring(pos+1));
            ice[a-1][b-1] = 1;
            ice[b-1][a-1] = 1;
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = i + 1 ; j < N ; j++) {
                for (int k = j + 1; k < N ; k++) {
                    if (ice[i][j] == 0 && ice[i][k] == 0 && ice[j][k] == 0) total++;
                }
            }
        }

        System.out.println(total);


    }
}
