import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15787 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//N번까지 있는 기차 좌석은 1~20번
		int[][] train = new int[N + 1][21];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int car, seat;
			switch (op) {
			//1번 명령 
			case 1:
				car = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());
				train[car][seat] = 1;
				break;
			//2번명령
			case 2:
				car = Integer.parseInt(st.nextToken());
				seat = Integer.parseInt(st.nextToken());
				train[car][seat] = 0;
				break;
			//3번명령 : car번 기차 좌석 뒤로 밀기
			case 3:
				car = Integer.parseInt(st.nextToken());
				for (int c = 20; c > 1; c--) {
					train[car][c] = train[car][c - 1];
				}
				train[car][1] = 0;
				break;
			//4번명령 : car번 기차 좌석 앞으로 밀기
			case 4:
				car = Integer.parseInt(st.nextToken());
				for (int c = 1; c < 20; c++) {
					train[car][c] = train[car][c + 1];
				}
				train[car][20] = 0;
				break;
			}
		}
		
		//기차 배열을 스트링으로 바꿔서 Set에 담아 중복 제거한 개수 출력
		Set<String> set = new HashSet<String>();
		for (int i = 1; i <= N; i++) {
			set.add(Arrays.toString(train[i]));

		}
		System.out.println(set.size());

	}
}
