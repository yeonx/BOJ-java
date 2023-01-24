import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i=N-1; i>=0 ;i--){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<i;j++){import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

                public class Main {

                    public static void main(String[] args) throws IOException {

                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        StringTokenizer st = new StringTokenizer(br.readLine());

                        int N = Integer.parseInt(st.nextToken());

                        for(int i=N-1; i>=0 ;i--){
                            StringBuilder sb = new StringBuilder();
                            for(int j=0;j<i;j++){
                                sb.append(" ");
                            }
                            for(int j=i; j<(2*N-i)-1 ;j++){
                                sb.append("*");
                            }
                            System.out.println(sb);
                        }

                        for(int i=1;i<2*N;i++){
                            StringBuilder sb = new StringBuilder();
                            for(int j=0;j<i;j++){
                                sb.append(" ");
                            }
                            for(int j=i;j<(2*N-1)-i;j++){
                                sb.append("*");
                            }
                            System.out.println(sb);
                        }

                    }
                }
                sb.append(" ");
            }
            for(int j=i; j<(2*N-i)-1 ;j++){
                sb.append("*");
            }
            System.out.println(sb);
        }

        for(int i=1;i<2*N;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<i;j++){
                sb.append(" ");
            }
            for(int j=i;j<(2*N-1)-i;j++){
                sb.append("*");
            }
            System.out.println(sb);
        }

    }
}
