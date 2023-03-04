import java.io.*;
import java.util.*;

public class Main_1 {

    static int answer;

    static void findRoom(int num){
        int number = 1;
        for(answer=1;;answer++){
            if(num <= number) return;
            number += (answer*6);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        findRoom(N);

        System.out.println(answer);
    }
}
