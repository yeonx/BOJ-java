package gold;

import java.util.*;
import java.io.*;

public class Main_9328_열쇠 {

    static int answer=0, key=0;
    static int H,W;
    static int map[][];
    static boolean vis[][][];

    static int[] dh = {0,0,-1,1};
    static int[] dw = {-1,1,0,0};
    static boolean alpha[];

    static void bfs(int h, int w){

        vis = new boolean[27][H + 2][W + 2];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {h,w});
        vis[key][h][w] = true;

        while(!q.isEmpty()) {

            int[] polled = q.poll();

            h = polled[0];
            w = polled[1];

            for (int d = 0; d < 4; d++) {
                int nh = dh[d] + h;
                int nw = dw[d] + w;

                if (0 <= nh && nh <= H + 1 && 0 <= nw && nw <= W + 1 && map[nh][nw] != -1 && !vis[key][nh][nw]) {
                    if (map[nh][nw] >= 100 ) {
                        if(!alpha[map[nh][nw] - 100]){
                            alpha[map[nh][nw] - 100] = true;
                            key++;
                        }
                        q.offer(new int[] {nh, nw});
                        vis[key][nh][nw] = true;
                    } else if (map[nh][nw] >= 0 && alpha[map[nh][nw]]) {
                        q.offer(new int[] {nh, nw});
                        vis[key][nh][nw] = true;
                    } else if (map[nh][nw] == -3) {
                        answer++;
                        map[nh][nw] = -2;
                        q.offer(new int[] {nh, nw});
                        vis[key][nh][nw] = true;
                    } else if (map[nh][nw] == -2) {
                        q.offer(new int[] {nh, nw});
                        vis[key][nh][nw] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {

            alpha = new boolean[26]; // 존재하는 알파벳 초기화
            answer = 0;
            key = 0;

            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new int[H + 2][W + 2];

            for(int h=0;h<=H+1;h++)
                Arrays.fill(map[h], -2);

            for (int h = 1; h <= H; h++) {
                String line = br.readLine();
                for (int w = 1; w <= W; w++) {
                    char current = line.charAt(w - 1);
                    if (current == '*') map[h][w] = -1; //벽
                    else if (current == '.') map[h][w] = -2; //빈공간
                    else if (current == '$') map[h][w] = -3; //문서
                    else if (current >= 'a' && current <= 'z') {
                        map[h][w] = current - 'a' + 100;
                    } else if (current >= 'A' && current <= 'Z') {
                        map[h][w] = current - 'A';
                    }
                }
            }

            String line = br.readLine();
            if (!line.equals("0")) {
                for (int j = 0; j < line.length(); j++) {
                    char tmp = line.charAt(j);
                    if(!alpha[tmp - 'a']) {
                        alpha[tmp - 'a'] = true;
                        key++;
                    }
                }
            }
            int preKey=key;
            for(int h=0;h<=H+1;h++){
                if(1<=h && h<=H ) continue;
                preKey=key;
                for(int w=0;w<=W+1;w++){
                    if(1<=w && w<=W) continue;
                    bfs(h,w);
                }
                if(preKey!=key) h=-1;
            }

            sb.append(answer + "\n");
        }

        System.out.println(sb);

    }
}

