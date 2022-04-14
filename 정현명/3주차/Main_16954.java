import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16954 {

	static char[][][] map;
	static int[][] deltas = {{0,0},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시간이 흐른 각 초당 체스판의 상태(8초 이후엔 벽이 없다)
		map = new char[8][8][8];
		
		for(int i=0;i<8;i++) {
			String line = br.readLine();
			for(int j=0;j<8;j++) {
				char c =line.charAt(j);
				if(c == '#') {
					for(int k=0;k<8;k++) {
						if(i+k <8) map[k][i+k][j] ='#'; 
					}
				}
			}
		}
		
		answer = 0;
		
		dfs(7,0,0);
		System.out.println(answer);
	}
	
	// 욱제 이동
	static void dfs(int r, int c, int t) {
		// 8초를 버티면 게임 승리
		if(t == 8) {
			answer = 1;
			return;
		}
		// 벽이 내려온 상태의 맵에서 벽과 위치가 동일 == 부딪힘
		if(map[t][r][c] == '#') {
			return;
		}
		
		for(int i=0;i<9;i++) {
			int nR = r + deltas[i][0];
			int nC = c + deltas[i][1];
			
			// 맵을 벗어나거나 벽으로 이동할 수 없음
			if(nR<0||nR>=8||nC<0||nC>=8||map[t][nR][nC]=='#') continue;
			dfs(nR,nC,t+1);
		}
	}
	
}
