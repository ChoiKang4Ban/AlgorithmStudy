import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_15787 {

	static int[] trains;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 기차 배열 (인덱스 1 부터 시작, N까지)
		trains = new int[N+1];
		
		// 명령어 수행
		for(int i=0;i<M;i++) {
			excute(br.readLine());
		}
		
		// 중복 제거
		HashSet<Integer> set = new HashSet<>();
		for(int i=1;i<N+1;i++) {
			set.add(trains[i]);
		}
		
		// 출력
		System.out.println(set.size());
		
	}
	
	public static void excute(String command) {
		StringTokenizer st = new StringTokenizer(command);
		
		int c = Integer.parseInt(st.nextToken()); // 명령
		int i = Integer.parseInt(st.nextToken()); // 기차 번호
		int x = -1; // 좌석 번호 ( x가 1부터 시작해서 0부터로 바꿔주기 위해 초기값 -1로 설정, 이후 x에 입력값을 더하는 방식)
		
		switch (c){
		// i번째 기차 x번째 좌석에 사람 태우기
		case 1:
			x += Integer.parseInt(st.nextToken());
			trains[i] |= (1 << x);
			break;
		// i번째 기차 x번째 좌석의 사람 하차시키기
		case 2:
			x += Integer.parseInt(st.nextToken());
			trains[i] &= ~(1 << x);
			break;
		// i번째 기차 한 칸씩 뒤로 밀고 맨 뒤 사람 하차시키기
		case 3:
			trains[i] = (trains[i] & ~(1 << 19)) << 1;
			break;
		// i번째 기차 맨 앞 사람 하차시키고 한 칸씩 앞으로 당기기
		case 4:
			trains[i] = (trains[i] & ~(1 << 0)) >> 1;
			break;
		}
	}

}
