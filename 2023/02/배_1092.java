import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int shipNum, luggageNum, answer, visCount;
    static int[] shipList ,luggageList;
    static ArrayList<Integer> luggageLL, shipLL;
    static ArrayDeque<Integer> luggage = new ArrayDeque<>(), ship = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        shipNum = Integer.parseInt(br.readLine());
        shipList = new int[shipNum];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<shipNum;i++) shipList[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(shipList);



        luggageNum = Integer.parseInt(br.readLine());
        luggageList = new int[luggageNum];
        luggageLL = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<luggageNum;i++) {
            luggageList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(luggageList);

//        for(int i=0;i<luggageNum;i++) luggage.offer(luggageList[i]);
        for(int i=0;i<luggageNum;i++) luggageLL.add(luggageList[i]);

        if (shipList[shipNum - 1] < luggageLL.get(luggageNum-1)) {
            answer = -1;
        } else {
            linkedListSolve();
//            visitedSolve();
//            dequeSolve();
        }
        System.out.println(answer);
    }

    static void linkedListSolve(){
        while (!luggageLL.isEmpty()){
            for(int i=shipNum-1;i>=0;i--){
                for(int j=luggageLL.size()-1;j>=0;j--){
                    if(luggageLL.get(j) <= shipList[i]){
                        luggageLL.remove(j);
                        break;
                    }
                }
            }
            answer++;
        }
    }

    /**
     * 시간초과
     */
    static void visitedSolve(){
        boolean[]  luggageV = new boolean[luggageNum];
        while (visCount!=luggageNum){
            for(int i=shipNum-1;i>=0;i--){
                for(int j=luggageNum-1;j>=0;j--){
                    if(luggageList[j] <= shipList[i] && !luggageV[j]){
                        visCount++;
                        luggageV[j]=true;
                        break;
                    }
                }
            }
            answer++;
        }
    }

    /**
     * 최적의 경우를 고려하지 못함
     *
     * 4
     * 1 2 3 4
     * 8
     * 1 1 2 2 3 3 4 4
     */
    static void dequeSolve(){
        while (!luggage.isEmpty()) {
            ship = new ArrayDeque<>();
            for (int i = 0; i < shipNum; i++) ship.offer(shipList[i]);
            while (!ship.isEmpty() && !luggage.isEmpty()) {
                while(true) {
                    if (ship.getFirst() < luggage.getFirst()) {
                        ship.pollFirst();
                    }else{
                        break;
                    }
                }
                if (ship.getLast() >= luggage.getLast()) {
                    ship.pollLast();
                    luggage.pollLast();
                } else if(ship.getFirst() >= luggage.getFirst()) {
                    ship.pollFirst();
                    luggage.pollFirst();
                }else{
                    break;
                }
            }
            answer++;
        }
    }
}
