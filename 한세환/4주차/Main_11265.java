import java.io.*;
import java.util.*;

public class Main_11265 {
    static int n, tc;
    static int dist[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tc = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워셜 : 직행으로 가지않고 어디 들렀다가 가는 형식
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(dist[A-1][B-1] <= C) {
                sb.append("Enjoy other party\n");
            }else {
                sb.append("Stay here\n");
            }
        }
        System.out.println(sb.toString());



    }
}
