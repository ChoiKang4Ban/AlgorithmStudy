import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10703 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][S];
		
		//bottom[] : 각 열별로 가장 낮은 운석의 위치
		//top[] : 각 열별로 가장 높은 땅의 위치
		int[] bottom=new int[S];
		int[] top=new int[S];
		for (int i = 0; i < S; i++) {
			top[i]=R;
			bottom[i]=-1;
		}
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < S; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='X') bottom[j]=i;
				if(map[i][j]=='#'&&top[j]==R) top[j]=i;
			}
		}
		
		//min : 땅과 운석의 차이가 가장 적은 곳의 차이
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < S; i++) {
			//운석이 없는 열은 카운트 제외
			if(bottom[i]!=-1&&top[i]-bottom[i]-1<min) min=top[i]-bottom[i]-1;
		}
	
		//min만큼 각 열 운석 내리고 .으로 채우기 
		for (int i = 0; i < S; i++) {
			for (int j = top[i]-1; j >= 0; j--) {
				if(j-min<0) map[j][i]='.';
				else map[j][i]=map[j-min][i];
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
}
