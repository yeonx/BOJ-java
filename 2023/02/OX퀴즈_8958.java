import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String str = br.readLine();
            int count=0;
            int s = 0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='O'){
                    s++;
                    count = count + s;
                }else{
                    s=0;
                }
            }
            System.out.println(count);
        }
    }
}
