import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int pos = input.indexOf(" ");

        String N = input.substring(0,pos);
        int K = Integer.parseInt(input.substring(pos+1));
        int[] num = new int[K];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<K ; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int answer = 0;

        int first = Integer.parseInt(String.valueOf(N.charAt(0))) * 10 + Integer.parseInt(String.valueOf(N.charAt(1)));

        int[] number = new int [K*K + K];
        for(int i=0;i< K ;i++){
            number[i] = num[i];
        }

        int k = K;
        for(int i=0; i<K ;i++){
            for(int j=0; j<K ;j++){
                number[k++] = num[i]*10 + num[j];
            }
        }

        number = Arrays.stream(number).distinct().toArray();
        Arrays.sort(number);
//        System.out.println(Arrays.toString(number));


        int flag=0;
        int tmp=0;

        for(int i=number.length-1 ; i >= 0 ; i--){
            if (i>=1 && number[i] == first){
                answer = number[i-1];
                tmp = first;
                flag = 1;
                break;
            } else if(number[i] < first){
                answer = number[i];
                break;
            }
        }

        for(int i=2 ; i<N.length() ; i++){
            answer = answer*10 + num[K-1];
        }

//        System.out.println(answer);

        if(flag==1){
            for(int i=2;i<N.length();i++){
                for(int j=K-1;j>=0;j--){
                    if (Integer.parseInt(String.valueOf(N.charAt(i))) >= num[j]){
                        tmp = tmp*10 + num[j];
                        break;
                    }
                }
            }
            if(answer<tmp)
                answer = tmp;
        }
        System.out.println(answer);
    }
}
