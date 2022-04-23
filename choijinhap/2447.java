import java.util.Scanner;

public class Main_2447 {
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][N];
		//배열 초기화 때문에 틀렸었음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=' ';
			}
		}
		getStars(0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void getStars(int xStart, int yStart, int size) {
		if (size == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//가운데 비우기
					if (i == 1 && j == 1)
						continue;
					map[xStart + i][yStart + j] = '*';
				}
			}
			return;
		}

		getStars(xStart, yStart, size / 3);
		getStars(xStart, yStart + size / 3, size / 3);
		getStars(xStart, yStart + size * 2 / 3, size / 3);
		getStars(xStart + size / 3, yStart, size / 3);
//		가운데는 비우기
//		getStars(xStart+size/3, yStart+size/3, size/3);
		getStars(xStart + size / 3, yStart + size * 2 / 3, size / 3);
		getStars(xStart + size * 2 / 3, yStart, size / 3);
		getStars(xStart + size * 2 / 3, yStart + size / 3, size / 3);
		getStars(xStart + size * 2 / 3, yStart + size * 2 / 3, size / 3);
	}

}
