import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11265 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int mat[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				if(i==k) continue;
				for(int j=0;j<N;j++) {
					if(i==j || j==k) continue;
					if(mat[i][j] > mat[i][k]+mat[k][j]) {
						mat[i][j] = mat[i][k]+mat[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int time = Integer.parseInt(st.nextToken());
			
			if(time >= mat[start][end]) {
				sb.append("Enjoy other party\n");
			}else sb.append("Stay here\n");
		}
		
		System.out.print(sb);
	}

}
