import java.util.*;
import java.io.*;

public class Main_11052 {
    static int n;
    static int arr[],dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1]; // 카드를 저장할 배열
        dp = new int[n+1];  // dp에 활용할 배열
        st = new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //  D[i] = arr[n] + D[i-n]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[n]);

    }
}
