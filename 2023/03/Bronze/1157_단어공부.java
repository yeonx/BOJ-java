import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        String str = br.readLine();

        int count=0;
        int[] alph = new int[26];

        for(int i=0;i<26;i++)
            alph[i]=0;

        str = str.toUpperCase();
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);

            alph[tmp-'A']++;
        }

        char answer= '?';
        for(int i=0;i<26;i++){
            count = Math.max(count, alph[i]);
            if(count==alph[i])
                answer = (char) ('A' + i);
        }

        int num=0;
        for(int i=0;i<26;i++){
            if(count == alph[i]) num++;
        }

        if(num==1)
            System.out.println(answer);
        else System.out.println("?");
    }
}
