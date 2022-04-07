import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16954 {
	static final int SIZE = 8;
	static char[][] map;
	static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static boolean answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			String str = br.readLine();
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		play(0, 7, 0);
		if (answer)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static void play(int cnt, int x, int y) {
		// 정답 한번 찾으면 더 찾을 필요 없음
		if (answer)
			return;
		// SIZE-1 번 버티면 성공
		if (cnt == SIZE - 1) {
			answer = true;
			return;
		}

		// 인접,대각선방향 확인
		for (int d = 0; d < 9; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE) {
				// 현재 진행한 cnt를 더해 벽을 내려준다.
				// 가려는곳이 . 이고 가려는 곳 위도 . 인지 확인
				if ((nx - cnt < 0 || map[nx - cnt][ny] == '.') && (nx - cnt - 1 < 0 || map[nx - cnt - 1][ny] == '.')) {
					play(cnt + 1, nx, ny);
				}
			}
		}
	}

}
