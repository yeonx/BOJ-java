import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        String[] wordsO = new String[N];

        for(int i=0;i<N;i++){
            wordsO[i] = br.readLine();
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(wordsO[i]);
        }

        String[] words = new String[set.size()];


        int index=0;
        for(String i : set){
            words[index++] = i;
        }

        Arrays.sort(words);

        Arrays.sort(words, (o1,o2)->{
            return o1.length() - o2.length();
        });


        for(String str:words){
            System.out.println(str);
        }
    }
}
