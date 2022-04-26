import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2447 {
	static char[][] answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		answer = new char[N][N];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(answer[i], '*');
		}
		removeMid(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(answer[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void removeMid(int r, int c, int n) {
		int nextN = n/3;
		for(int i=r+nextN;i<r+nextN*2;i++) {
			for(int j=c+nextN;j<c+nextN*2;j++) {
				answer[i][j] = ' ';
			}
		}
		if(nextN != 1) {
			removeMid(r, c, nextN);
			removeMid(r, c+nextN, nextN);
			removeMid(r, c+nextN*2, nextN);
			removeMid(r+nextN, c, nextN);
			removeMid(r+nextN*2, c, nextN);
			removeMid(r+nextN*2, c+nextN, nextN);
			removeMid(r+nextN, c+nextN*2, nextN);
			removeMid(r+nextN*2, c+nextN*2, nextN);
		}
	}

}
